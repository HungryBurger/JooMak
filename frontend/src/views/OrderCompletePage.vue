<template>
  <div id="order-status-page">
    <div id="row order-status-container">
      <h1>
        주문 완료
      </h1>
      <img
        class="main-logo"
        src="@/assets/images/order-complete-img.svg"
        alt="JoomakLogo"
      />
      <div>
        <router-link
          class="back-button btn btn-lg"
          to="/"
          @click="goHome('homePage')"
          >홈으로
        </router-link>
        <router-link class="front-button btn btn-lg" to="/order-status"
          >주문 현황
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
#order-status-page {
  padding: 48px;
  width: 100%;
  text-align: center;
}
#order-status-container {
  margin: 0px 120px;
  padding: 24px;
}
img {
  padding: 48px;
}
h1 {
  font-size: 24px;
}
.back-button {
  outline: 0;
  background: #ffc463;
  border: 0;
}
.front-button {
  outline: 0;
  background: #ff4c3c;
  border: 0;
}
.back-button,
.front-button {
  width: 180px;
  margin: 32px;
  padding-top: 12px;
}
</style>
