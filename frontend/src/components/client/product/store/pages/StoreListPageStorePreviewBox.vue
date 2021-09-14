<template>
  <div id="store-preview-box">
    <div id="store-preview-box_header">
      <div
        :class="{ 'on-info': previewTab === 'info' }"
        @click="onClickPreviewTab('info')"
      >
        매장 정보
      </div>
      <div
        :class="{ 'on-review': previewTab === 'review' }"
        @click="onClickPreviewTab('review')"
      >
        리뷰
      </div>
    </div>
    <div id="store-preview-box_main-wrap">
      <div id="store-preview-box_main">
        <div
          class="store-preview-box_main-content"
          v-if="previewTab === 'info'"
        >
          매장 정보 부분입니다
        </div>
        <div
          class="store-preview-box_main-content"
          v-else-if="previewTab === 'review'"
        >
          리뷰 미리보기 부분입니다
        </div>
      </div>
    </div>
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
import { SET_ON_PREVIEW_BOX, SET_PREVIEW_TAB } from "@/store/modules/common.js";

export default {
  computed: {
    ...mapState("common", ["onPreviewBox", "previewTab"]),
  },
  methods: {
    onClickPreviewTab(tabName) {
      if (tabName !== this.previewTab) {
        this.$store.commit(`common/${SET_PREVIEW_TAB}`, tabName);
      }
    },
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
  created() {
    if (this.previewTab !== "info") {
      this.$store.commit(`common/${SET_PREVIEW_TAB}`, "info");
    }
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

#store-preview-box_header {
  display: flex;
  width: 100%;
  height: 9vh;
  background-color: #ffe46a;
}
#store-preview-box_header > div {
  cursor: pointer;
  color: #858585;
  font-size: 16px;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
}
#store-preview-box_header > div.on-info {
  background-color: #fff0b1;
  color: #292929;
  border-top-right-radius: 3vh;
}
#store-preview-box_header > div.on-review {
  background-color: #fff0b1;
  color: #292929;
  border-top-left-radius: 3vh;
}

#store-preview-box_main-wrap {
  box-sizing: border-box;
  padding-top: 2.5vh;
  padding-bottom: 2.5vh;
  padding-left: 10px;
  overflow-y: scroll;
  display: flex;
  justify-content: center;
  width: 100%;
  height: 79vh;
  background-color: #fff0b1;
}
#store-preview-box_main-wrap:hover::-webkit-scrollbar-thumb {
  background-color: rgba(0, 0, 0, 0.4);
}
#store-preview-box_main-wrap::-webkit-scrollbar {
  width: 10px;
  height: 100%;
}
#store-preview-box_main {
  width: 25vw;
  height: 120%;
  background-color: #fff5eb;
}

#preview_switch {
  display: flex;
  align-items: center;
  position: absolute;
  top: 41vh;
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
