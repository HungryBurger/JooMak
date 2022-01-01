<template>
  <div>
    주문 & 결제 페이지 입니다<br />
    현재 주문하려는 항목은
    <span v-for="(order, i) in orderForm" :key="i">{{ order.name }}&nbsp;</span
    >입니다.
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState("order", ["orderForm"]),
  },
  created() {
    console.log(this.orderForm[0]);
  },
};
</script>

<style></style>
