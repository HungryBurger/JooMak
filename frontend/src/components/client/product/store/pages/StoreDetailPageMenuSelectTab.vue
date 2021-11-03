<template>
  <div id="menu-select-tab">
    <store-detail-page-product-group-box
      v-for="productGroup in products.allProducts"
      :key="productGroup.groupIdx"
      :productGroup="productGroup"
    ></store-detail-page-product-group-box>
  </div>
</template>

<script>
import StoreDetailPageProductGroupBox from "../components/StoreDetailPageProductGroupBox.vue";

export default {
  props: ["products"],
  components: {
    StoreDetailPageProductGroupBox,
  },
  methods: {},
};
</script>

<style>
#menu-select-tab {
  display: flex;
  flex-direction: column;
  gap: 10vh;
  position: relative;
  padding: 15vh 100px;
}
#menu-select-tab::before {
  position: absolute;
  top: 0;
  left: 98px;
  content: "";
  display: block;
  width: 2px;
  height: 100%;
  background-color: #ffdd1b;
}
</style>
