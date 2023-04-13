from flask import Flask, jsonify, request
import pymysql
from flask_cors import CORS

app = Flask(__name__)
CORS(app)


# 将数据库连接的代码封装成函数
def get_db_conn():
    return pymysql.connect(
        host='sepbifang.mysql.rds.aliyuncs.com',
        port=3306,
        user='heyi755',
        password='heyi1456',
        database='subseller',
        charset='utf8mb4'
    )


@app.route('/submit', methods=['POST'])
def submit_orders():
    data = request.get_json()
    seller = data['seller']
    items = data['items']
    start_time = data['start_time']
    end_time = data['end_time']

    # 使用 with 语句来管理数据库连接和游标对象
    with get_db_conn() as conn, conn.cursor() as cursor:
        # 生成订单号
        sql = "SELECT MAX(order_id) FROM orders"
        cursor.execute(sql)
        order_id = cursor.fetchone()[0]
        if order_id is None:
            order_id = 1
        else:
            order_id += 1

        # 生成订单
        sql = "INSERT INTO orders (order_id, seller, start_time, end_time) VALUES (%s, %s, %s, %s)"
        cursor.execute(sql, (order_id, seller, start_time, end_time))

        # 生成订单项
        sql = "INSERT INTO order_items (order_id, product_id, quantity, unit_price, name) VALUES (%s, %s, %s, %s, %s)"
        values = [(order_id, item['product_id'], item['quantity'], item['unit_price'], item['name']) for item in items]
        cursor.executemany(sql, values)

        # 提交到数据库执行
        conn.commit()

    return jsonify({'status': 'success'})


@app.route('/payment', methods=['GET'])
def get_payment():
    # 使用 with 语句来管理数据库连接和游标对象
    with get_db_conn() as conn, conn.cursor() as cursor:
        # 通过检索商家名获取订单
        sql = "SELECT * FROM orders WHERE seller = %s"
        cursor.execute(sql, 'heyi')
        orders = cursor.fetchall()

        # 通过计算订单项的总价来获取订单总价
        for i, order in enumerate(orders):
            sql = "SELECT SUM(quantity * unit_price) FROM order_items WHERE order_id = %s"
            cursor.execute(sql, order[0])
            total_price = cursor.fetchone()[0]
            orders[i] = orders[i] + (total_price,)

        # 计算订单总价
        payment = sum([order[4] for order in orders])

    return jsonify({'value': payment})


if __name__ == '__main__':
    app.run()
