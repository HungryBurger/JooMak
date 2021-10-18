<template>
  <div id="order-status-page">
    <div class="order-status-page-wrap">
      <div class="title">
        <h3>
          주문 현황
        </h3>
      </div>
      <div class="stepper-wrapper">
        <div class="stepper-item completed">
          <div class="step-counter">1</div>
          <div class="step-name">접수 대기</div>
        </div>
        <div class="stepper-item completed">
          <div class="step-counter">2</div>
          <div class="step-name">주문 접수</div>
        </div>
        <div class="stepper-item active">
          <div class="step-counter">
            <div class="spinner-grow active-spinner" role="status">
              <span class="visually-hidden">Loading...</span>
            </div>
          </div>
          <div class="step-name">배달 접수</div>
        </div>
        <div class="stepper-item">
          <div class="step-counter">4</div>
          <div class="step-name">배달 완료</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.order-status-wrap {
  z-index: 1;
  background: #ffffff;
  height: 2000px;
  margin: 0px 120px;
  padding: 24px;
}
.active-spinner {
  color: #ffc463;
}
h3 {
  text-decoration: underline;
  -webkit-text-decoration-color: #ffc463; /* Safari */
  text-decoration-color: #ffc463;
}
.title {
  text-align: center;
}
#order-status-page {
  margin: 36px;
}
.stepper-wrapper {
  /* margin-top: auto; */
  display: flex;
  justify-content: space-between;
  margin: 30px;
}
.stepper-item {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  flex: 1;

  @media (max-width: 768px) {
    font-size: 12px;
  }
}

.stepper-item::before {
  position: absolute;
  content: "";
  border-bottom: 2px solid #ccc;
  width: 100%;
  top: 30px;
  left: -50%;
  z-index: 2;
}

.stepper-item::after {
  position: absolute;
  content: "";
  border-bottom: 2px solid #ccc;
  width: 100%;
  top: 30px;
  left: 50%;
  z-index: 2;
}

.stepper-item .step-counter {
  position: relative;
  z-index: 5;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background: #ccc;
  margin-bottom: 6px;
}

.stepper-item.active {
  font-weight: bold;
}

.stepper-item.completed .step-counter {
  background-color: #ffc463;
}

.stepper-item.completed::after {
  position: absolute;
  content: "";
  border-bottom: 2px solid #ffc463;
  width: 100%;
  top: 30px;
  left: 50%;
  z-index: 3;
}

.stepper-item:first-child::before {
  content: none;
}
.stepper-item:last-child::after {
  content: none;
}
</style>
