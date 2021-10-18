<template>
  <div class="product-li" @click="onClickProductLi(product)">
    <div class="product-li_img_wrap">
      <img :src="product.img" :alt="product.name" />
    </div>
    <div class="product-li_content_wrap">
      <div class="content_left">{{ product.name }}</div>
      <div class="content_right">{{ price }} 원</div>
    </div>
  </div>
</template>

<script>
import { SET_ON_MODAL } from "@/store/modules/common.js";
import { OPEN_MENU_SELECT_MODAL } from "@/store/modules/product.js";
import { mapActions } from "vuex";

export default {
  props: ["product"],
  computed: {
    price() {
      let num = this.product.price;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions("product", [OPEN_MENU_SELECT_MODAL]),
    openModal(productObj) {
      this.OPEN_MENU_SELECT_MODAL(productObj);
      // this.$store.commit(`common/${SET_ON_MODAL}`, true);
    },
    closeModal() {
      console.log("close event 발생");
    },
    onClickProductLi(productObj) {
      this.openModal(productObj);
    },
  },
};
</script>

<style>
#store-detail-page_bottom .product-li {
  cursor: pointer;
  display: flex;
  align-items: center;
  width: 100%;
  height: 15vh;
  border: 1px solid #e0e0e0;
  border-bottom-right-radius: 3vh;
}
#store-detail-page_bottom .product-li:hover {
  border-color: #ffdd1b;
}
#store-detail-page_bottom .product-li:hover .product-li_img_wrap {
  border-right-color: #ffdd1b;
}
#store-detail-page_bottom .product-li_img_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  height: 15vh;
  width: 15vh;
  border-right: 1px solid #e0e0e0;
}
#store-detail-page_bottom .product-li_img_wrap > img {
  height: auto;
  width: 100%;
}
#store-detail-page_bottom .product-li_content_wrap {
  height: 100%;
  padding: 3vh;
  width: calc(100% - 15vh);
  display: flex;
  justify-content: space-between;
  gap: 2vh;
}
#store-detail-page_bottom .product-li_content_wrap .content_right {
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
}
</style>
