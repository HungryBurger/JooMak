<template>
  <div id="store-intro-tab">
    <div class="card intro-card">
      <div class="card-header">
        주막 소개
      </div>
      <div class="card-body">
        <!-- <h5 class="card-title">Special title treatment</h5> -->
        <img src="https://www.yupdduk.com/images/logo61.png" class="rounded float-left" alt="...">
        <p class="card-text">교촌치킨
전국 1위 맛집
*교촌치킨 정자점은 고객님의 기대에 부응하기 위해 매일 신선한 냉장육과 깨끗한 카놀라유로 정성껏 조리하며, 고객님들께 절대 실망 시키지 않도록 최선을 다하겠습니다.
*따듯한 음식을 고객님께 최대한 빨리 배달하기 위해 배달 대행이 아닌 직접저희 직원이 갈 수 있도록 항상 최선을 다하고 있습니다.
*붉은 치킨 속살 걱정 마세요~
닭고기에 일부 함유된 단백질(미오글라빈)으로 인한 핑킹현상입니다.</p>
        <!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        영업 정보
      </div>
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
    <div class="card order-card">
      <div class="card-header">
        주문 현황
      </div>
      <div class="card-body">
        <div class="card-text total-order">총 주문 횟수: </div>
       <div class="card-text total-order-per-month">1달간주문 횟수: </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        배달 요금
      </div>
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        위치 정보
      </div>
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {},
};
</script>
<style  scoped>
#store-intro-tab {
  display: flex;
  flex-direction: column;
  gap: 10vh;
  position: relative;
  padding: 10vh 50px;
}
.card-header{
  background-color:#FFF0B1;
}
.card-body{
  padding:20px;
  overflow:hidden;
}
.intro-card .card-body img{
  margin-right:50px;
  float:left;
}
.intro-card .card-body p{
   margin-left: 15px;
    display: block;
}
.order-card .card-body {
    display: flex;
    justify-content: space-around;
}
</style>
