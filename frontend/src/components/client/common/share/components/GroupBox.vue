<template>
  <div class="group-box">
    <div class="group-name">{{ title }}</div>
    <div class="group-content">
      <slot name="content" />
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      required: false,
    },
  },
};
</script>

<style scoped>
.group-box .group-name {
  margin-bottom: 5vh;
  width: 15vw;
  height: 5vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ffdd1b;
  font-weight: bold;
}
.group-box .group-content {
  padding: 0 4vw;
}
</style>
