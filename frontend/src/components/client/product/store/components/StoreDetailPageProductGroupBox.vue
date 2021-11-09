<template>
  <div class="product-group-box">
    <div class="group-name">{{ productGroup.groupName }}</div>
    <div class="detail-page_product-li_wrap">
      <div v-if="productGroup.products.length === 0">상품을 준비 중입니다.</div>
      <store-detail-page-product-li
        v-for="product in productGroup.products"
        :key="product.productIdx"
        :product="product"
      ></store-detail-page-product-li>
    </div>
  </div>
</template>

<script>
import StoreDetailPageProductLi from "./StoreDetailPageProductLi.vue";

export default {
  props: ["productGroup"],
  components: {
    StoreDetailPageProductLi,
  },
};
</script>

<style>
#store-detail-page_bottom .group-name {
  margin-bottom: 5vh;
  width: 15vw;
  height: 5vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ffdd1b;
  font-weight: bold;
}

.detail-page_product-li_wrap {
  padding-left: 4vw;
  padding-right: 4vw;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 4vh 5vw;
}
</style>
