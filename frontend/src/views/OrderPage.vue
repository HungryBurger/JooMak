<template>
  <div v-if="orderFormList.length > 0" id="orderPage">
    <header>
      <h3>주문 / 결제</h3>
      <img :src="iconJoomakPath" alt="icon_joomak" class="icon_joomak" />
      <img :src="iconJoomoPath" alt="icon_joomo" class="icon_joomo" />
      <img :src="iconChefHatPath" alt="icon_chef-hat" class="icon_chef-hat" />
    </header>
    <div class="content">메인영역</div>
  </div>
  <div v-else id="orderPage">
    주문할 상품이 없습니다.
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState("order", ["orderFormList"]),
    iconJoomakPath() {
      return require("@/assets/images/icon_order_joomak.svg");
    },
    iconJoomoPath() {
      return require("@/assets/images/icon_order_joomo.svg");
    },
    iconChefHatPath() {
      return require("@/assets/images/icon_order_chef-hat.svg");
    },
  },
  created() {
    console.log(this.orderFormList[0]);
  },
};
</script>

<style></style>
