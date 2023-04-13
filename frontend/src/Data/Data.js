// Sidebar imports
import {
  UilEstate,
  UilClipboardAlt,
  UilUsersAlt,
  UilPackage,
  UilChart,
  // UilSignOutAlt,
} from "@iconscout/react-unicons";

// Analytics Cards imports
import { UilUsdSquare, UilMoneyWithdrawal } from "@iconscout/react-unicons";
// import { keyboard } from "@testing-library/user-event/dist/keyboard";

// Recent Card Imports

export const SidebarData = [
  {
    icon: UilEstate,
    heading: "总览",
    to: "/"
  },
  {
    icon: UilClipboardAlt,
    heading: "下单",
    to: "/submit"
  },
  {
    icon: UilUsersAlt,
    heading: "客户",
    link: "/customers"
  },
  {
    icon: UilPackage,
    heading: "退货",
    link: "/sales"
  },
  {
    icon: UilChart,
    heading: "分析",
    link: "/analytics"
  },
];


// Analytics Cards Data
export const cardsData = [
  {
    title: "账单",
    color: {
      // backGround: "linear-gradient(180deg, #bb67ff 0%, #c484f3 100%)",
      backGround:  "linear-gradient(rgb(248, 212, 154) -146.42%, rgb(255 202 113) -46.42%)",
      boxShadow: "0px 10px 20px 0px #e0c6f5",
    },
    barValue: 100,
    value: "25,000",
    png: UilUsdSquare,
    series: [
      {
        name: "Sales",
        data: [3000, 4000, 3500, 2500, 2000, 5000, 5000],
      },
    ],
  },
  {
    title: "仓储量",
    color: {
      // backGround: "linear-gradient(180deg, #FF919D 0%, #FC929D 100%)",
      backGround: "linear-gradient(180deg, #FF919D 0%, #FC929D 100%)",
      boxShadow: "0px 10px 20px 0px #FDC0C7",
    },
    barValue: 80,
    value: "20,000",
    png: UilMoneyWithdrawal,
    series: [
      {
        name: "Revenue",
        data: [2400, 3300, 2700, 2000, 1600, 3800, 4200],
      },
    ],
  },
  {
    title: "已售出",
    color: {
      // backGround:
      //   "linear-gradient(rgb(248, 212, 154) -146.42%, rgb(255 202 113) -46.42%)",
      backGround:
      "linear-gradient(180deg, #bb67ff 0%, #c484f3 100%)",
      boxShadow: "0px 10px 20px 0px #F9D59B",
    },
    barValue: 20,
    value: "5,000",
    png: UilClipboardAlt,
    series: [
      {
        name: "Expenses",
        data: [600, 700, 800, 500, 400, 1200, 800],
      },
    ],
  },
];

// Recent Update Card Data
export const UpdatesData = [
  {
    name: "仓库管理员",
    noti: "您的货物存储时间即将到期，请及时续费"
  },
  {
    name: "仓库系统",
    noti: "您的货物已经被分配至相关货架"
  },
  {
    name: "货运负责人",
    noti: "司机已经就绪，可以开始装运"
  },
];
