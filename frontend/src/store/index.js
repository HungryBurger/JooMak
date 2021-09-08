import { createStore } from "vuex";
import { common } from "./modules/common.js";
import { member } from "./modules/member.js";
import { order } from "./modules/order.js";
import { product } from "./modules/product.js";

export default createStore({
  modules: { common, member, order, product },
});
