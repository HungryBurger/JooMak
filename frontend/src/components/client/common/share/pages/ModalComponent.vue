<template>
  <div class="modal">
    <div class="overlay" @click="$emit('close')"></div>
    <div class="modal-card">
      <header class="modal-header">
        <slot name="header" />
        <h1>
          Title
          <img
            id="icon_close"
            src="@/assets/images/icon_close.svg"
            alt="icon_close"
            @click="$emit('close')"
          />
        </h1>
      </header>
      <div class="modal-content">
        <slot name="content">
          <h1>Content</h1>
        </slot>
      </div>
      <footer class="modal-footer">
        <slot name="footer">
          <h1>footer</h1>
          <button id="close-button" @click="$emit('close')">Close</button>
        </slot>
      </footer>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.modal,
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  text-align: center;
  color: #828282;
}
#close-button {
  cursor: pointer;
}
#icon_close {
  height: auto;
  width: 12px;
  position: absolute;
  top: 12px;
  right: 12px;
  color: #828282;
  cursor: pointer;
}
.overlay {
  opacity: 0.5;
  background-color: black;
}

.modal-card {
  position: relative;
  max-width: 50%;
  margin: auto;
  margin-top: 100px;
  padding: 20px;
  background-color: white;
  min-height: 500px;
  z-index: 10;
  opacity: 1;
}
header {
  border-bottom: 2px solid #9e9e9e;
}
footer {
  position: absolute;
  left: 0;
  bottom: 0;
  padding: 12px 0;
  width: 100%;
  /* border-top:1px solid; */
}
</style>
