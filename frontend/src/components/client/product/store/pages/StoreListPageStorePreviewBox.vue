<template>
  <div id="store-preview-box">
    <span>매장 미리보기 창 입니다</span>
    <div
      id="preview_switch"
      @click="onClickPreviewSwitch"
      :class="{ 'off-preview': !onPreviewBox }"
    >
      <img
        v-if="onPreviewBox"
        src="@/assets/images/store-list_arrow-left.svg"
        alt="arrow-left"
      />
      <img
        v-else-if="!onPreviewBox"
        src="@/assets/images/store-list_arrow-right.svg"
        alt="arrow-right"
      />
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { SET_ON_PREVIEW_BOX } from "@/store/modules/common.js";

export default {
  computed: {
    ...mapState("common", ["onPreviewBox"]),
  },
  methods: {
    closePreviewBox() {
      const storeListPageMainWrap = document.querySelector(
        "#store-list-page_main-wrap"
      );
      const storeListPageMain = document.querySelector("#store-list-page_main");
      const scaleBox = document.querySelector("#scale-box");
      const storePreviewBox = document.querySelector("#store-preview-box");

      storeListPageMainWrap.style.width = `${document.body.offsetWidth}px`;
      storeListPageMain.style.width = `${document.body.offsetWidth * 0.8}px`;
      storePreviewBox.style.width = `${document.body.offsetWidth * 0.28}px`;
      scaleBox.style.width = 0;
    },
    openPreviewBox() {
      const storeListPageMainWrap = document.querySelector(
        "#store-list-page_main-wrap"
      );
      const storeListPageMain = document.querySelector("#store-list-page_main");
      const scaleBox = document.querySelector("#scale-box");

      storeListPageMainWrap.style.width = `${document.body.offsetWidth *
        0.72}px`;
      storeListPageMain.style.width = `${document.body.offsetWidth * 0.72}px`;
      scaleBox.style.width = `${document.body.offsetWidth * 0.28}px`;
    },
    onClickPreviewSwitch() {
      // previewBox 닫기
      if (this.onPreviewBox) {
        this.closePreviewBox();
        this.$store.commit(`common/${SET_ON_PREVIEW_BOX}`, false);
      }
      // previewBow 열기
      else {
        this.openPreviewBox();
        this.$store.commit(`common/${SET_ON_PREVIEW_BOX}`, true);
      }
    },
  },
};
</script>

<style scoped>
#store-preview-box {
  transition: all 0.7s;
  position: relative;
  width: 28%;
  height: 100%;
  background-color: coral;
}
#preview_switch {
  display: flex;
  align-items: center;
  position: absolute;
  top: 39vh;
  right: 0;
  cursor: pointer;
  width: 3vh;
  height: 6vh;
  background-color: rgba(0, 0, 0, 0.2);
  border-top-left-radius: 3vh;
  border-bottom-left-radius: 3vh;
}
#preview_switch:hover {
  background-color: rgba(0, 0, 0, 0.5);
}
#preview_switch > img {
  position: absolute;
  right: 20%;
}
#preview_switch.off-preview > img {
  position: absolute;
  left: 20%;
}
#preview_switch.off-preview {
  right: -3vh;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
  border-top-right-radius: 3vh;
  border-bottom-right-radius: 3vh;
}
</style>
