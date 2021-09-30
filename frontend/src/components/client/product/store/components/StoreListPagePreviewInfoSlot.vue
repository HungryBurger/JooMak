<template>
  <div class="preview_info-slot_wrap">
    <div class="info-slot_top">
      <img :src="slotInfo.icon" :alt="slotInfo.iconAlt" />
      <h4>{{ slotInfo.title }}</h4>
    </div>
    <div class="info-slot_bottom">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  props: ["slotInfo"],
};
</script>

<style>
.info-slot_top {
  display: flex;
  padding-bottom: 1vh;
}
.info-slot_top > img {
  height: 15px;
  width: auto;
  margin-right: 1vh;
}
.info-slot_top > h4 {
  font-size: 14px;
}

.info-slot_bottom {
  font-size: 12px;
  padding: 0 2vh;
}
.info-slot_bottom > div {
  font-size: 12px;
}
</style>
