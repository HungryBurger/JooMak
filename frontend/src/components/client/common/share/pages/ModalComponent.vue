<template>
  <div class="modal_wrap">
    <div class="overlay" @click="closeModal" @wheel.prevent></div>
    <div class="modal_card">
      <header class="modal_header">
        <slot name="header">header</slot>
        <div id="icon_close_wrap" @click="closeModal">
          <svg
            width="20"
            height="20"
            viewBox="0 0 20 20"
            fill="#999999"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M20 2.01429L17.9857 0L10 7.98571L2.01429 0L0 2.01429L7.98571 10L0 17.9857L2.01429 20L10 12.0143L17.9857 20L20 17.9857L12.0143 10L20 2.01429Z"
            />
          </svg>
        </div>
      </header>
      <div class="modal_content">
        <slot name="content">
          <h1>Content</h1>
        </slot>
      </div>
      <footer class="modal_footer">
        <slot name="footer">
          footer
          <button id="close-button" @click="closeModal">Close</button>
        </slot>
      </footer>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { SET_ON_MODAL } from "@/store/modules/common.js";

export default {
  computed: {
    ...mapState("common", ["onModal"]),
  },
  methods: {
    closeModal() {
      this.$emit("close");
      this.$store.commit(`common/${SET_ON_MODAL}`, false);
    },
  },
  beforeUnmount() {
    if (this.onModal) {
      this.$store.commit(`common/${SET_ON_MODAL}`, false);
    }
  },
};
</script>

<style scoped>
.modal_wrap,
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  text-align: center;
  color: #828282;
}
.modal_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 100;
}
#close-button {
  cursor: pointer;
}
#icon_close_wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 12px;
  height: 12px;
  position: absolute;
  top: 12px;
  right: 12px;
  cursor: pointer;
}
#icon_close_wrap > svg {
  width: 100%;
  height: 100%;
  /* fill: #828282; */
}
#icon_close_wrap:hover > svg {
  fill: #292929;
}
.overlay {
  opacity: 0.5;
  background-color: black;
}

.modal_card {
  overflow-y: overlay;
  position: relative;
  min-width: 40vw;
  max-width: 80vw;
  padding: 20px;
  background-color: white;
  min-height: 80vh;
  max-height: 90vh;
  z-index: 10;
  opacity: 1;
}
.modal_card::-webkit-scrollbar {
  background-color: transparent;
}
header.modal_header {
  width: 100%;
}
.modal_content {
  width: 100%;
}
footer.modal_footer {
  width: 100%;
  /* border-top:1px solid; */
}

.modal_wrap .no-use {
  display: none;
  padding: 0;
  margin: 0;
  border: none;
}
</style>
