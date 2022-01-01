<template>
  <div>
    주문 & 결제 페이지 입니다<br />
    현재 주문하려는 항목은
    <span v-for="(orderForm, i) in orderFormList" :key="i"
      >{{ orderForm.name }}&nbsp;</span
    >입니다.
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState("order", ["orderFormList"]),
  },
  created() {
    console.log(this.orderFormList[0]);
  },
};
</script>

<style></style>
