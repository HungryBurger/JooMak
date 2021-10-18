<template>
  <div id="order-status-page">
    <div class="row justify-content-center order-status-page-wrap">
      <div class="title">
        <h3>
          주문 현황
        </h3>
      </div>
      <div class="col-10 stepper-wrapper">
        <div class="stepper-item completed">
          <div class="step-counter">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              fill="currentColor"
              class="bi bi-check2"
              viewBox="0 0 16 16"
            >
              <path
                d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"
              />
            </svg>
          </div>
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
      <div class="col-6 order-status-content">
        <h1>음식 준비중 . . .</h1>
        <li class="order-status-page_li">
          <div class="order-status-page_li_left">
            <div class="li_logo_wrap">
              <img src="https://www.yupdduk.com/images/logo61.png" />
            </div>
            <div class="li_info_wrap">
              <div class="li_info_middle">
                <span class="li_info_top">동대문 엽기 떡볶이-부평점</span>
              </div>
            </div>
            <div class="d-grid gap-2 d-md-block">
              <button class="btn secondary-button btn-sm m-2">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  class="bi bi-shop"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"
                  />
                </svg>
                가게 정보 보기
              </button>
              <button class="btn secondary-button btn-sm m-2">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  class="bi bi-cart-fill"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
                  />
                </svg>
                주문 상세 보기
              </button>
            </div>
          </div>
        </li>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.secondary-button {
  /* width: 200px; */
  background: #ffffff;
  border: 2px solid #ffc463;
  color: #828282;
  margin-right: 12px;
}
.order-status-wrap {
  /* z-index: 1; */
  /* margin: 0px 120px; */
  /* padding: 24px; */
}
.active-spinner {
  color: #ffc463;
}
.order-status-content {
  padding: 24px;
}
h3 {
  text-decoration: underline;
  -webkit-text-decoration-color: #ffc463; /* Safari */
  text-decoration-color: #ffc463;
  text-underline-offset: 4px;
}
.title {
  text-align: center;
  padding: 12px;
}
#order-status-page {
  margin: 36px;
}
h1 {
  padding-bottom: 40px;
  text-align: center;
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
  color: #ffffff;
  font-size: 18px;
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

.order-status-page_li {
  display: flex;
  cursor: pointer;
  display: flex;
  align-items: center;
  width: 100%;
  height: 12vh;
  padding-left: 1vh;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  /* margin-top: 24px; */
}
/* .order-status-page_li:hover,
.order-status-page_li:hover .li_logo_wrap {
  border-color: #ffdd1b;
} */

.order-status_li span:not(.li_info_top) {
  font-size: 12px;
}

.order-status-page_li_left {
  /* width: 90%; */
  display: flex;
  align-items: center;
  padding-right: 24px;
}

.li_logo_wrap {
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 10vh;
  height: 10vh;
  padding: 0.5vh;
}
.li_logo_wrap > img {
  width: 100%;
  height: auto;
}

.li_info_wrap {
  /* width: 80%; */
  padding-left: 2vh;
  padding-right: 48px;
  display: flex;
  flex-direction: column;
  gap: 0.5vh;
}

.li_info_middle {
  display: flex;
}
.li_info_middle_left,
.li_info_middle_right {
  display: flex;
  align-items: center;
}
.li_info_middle span {
  padding-left: 1vh;
  /* line-height: 1.3; */
  text-align: center;
}
.li_info_middle_left > img {
  height: 1.8vh;
  width: auto;
}
.li_info_middle_right {
  padding-left: 5vh;
}
.li_info_middle_right > img {
  height: 1.5vh;
  width: auto;
}
.li_info_bottom {
  display: flex;
}
.li_info_bottom > span:nth-child(2) {
  padding: 0 3vh;
}

.order-status-page_li_right {
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  overflow: hidden;
  position: relative;
  left: 1px;
  width: 17%;
  height: calc(100% + 2px);
}
.li_right_front,
.li_right_back {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}
.li_right_front {
  transition: 0.7s;
  z-index: 10;
  background-color: #ffdd1b;
}
.order-status-page_li_right:hover .li_right_front {
  transform: translateX(75%);
}
.order-status-page_li_right:hover .li_right_back > img {
  transform: translateX(-70%);
}
.li_right_front > img {
  width: auto;
  height: 17%;
}
.li_right_back {
  width: calc(100% - 1px);
  background-color: #b88154;
}
.li_right_back > img {
  transition: 0.7s;
  position: absolute;
  right: -20%;
  width: 60%;
  height: auto;
}
</style>
