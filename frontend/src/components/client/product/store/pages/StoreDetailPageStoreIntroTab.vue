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
        <div class="row justify-content-center">
          <div class="col-5">
            <div class="form-group row">
              <label for="storeName" class="col-sm-3 col-form-label">상호명</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="storeName" value="교촌치킨 정자점">
              </div>
            </div>
            <div class="form-group row">
              <label for="time" class="col-sm-3 col-form-label">운영 시간</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="time" value="매일 오전 11:00~ 밤 12:00 ">
              </div>
            </div>
             <div class="form-group row">
              <label for="phone" class="col-sm-3 col-form-label">전화 번호</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="phone" value="050-4831-3705">
              </div>
            </div>
          </div>
          <div class="col-5">
             <div class="form-group row">
              <label for="dayoff" class="col-sm-3 col-form-label">휴무일</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="dayoff" value="연중 무휴">
              </div>
            </div>
             <div class="form-group row">
              <label for="service" class="col-sm-3 col-form-label">포장/배달</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="service" value="포장/배달 가능">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card order-card">
      <div class="card-header">
        주문 현황
      </div>
      <div class="card-body">
        <div class="row justify-content-center">
          <div class="col-5">
            <div class="form-group row">
              <label  class="col-sm-3 col-form-label"></label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" value="">
              </div>
            </div>
             <div class="form-group row">
              <label for="minOrderPrice" class="col-sm-3 col-form-label">최소 주문 금액 :</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="minOrderPrice" value="15000원">
              </div>
            </div>
          </div>
           <div class="col-5">
            <div class="form-group row">
              <label for="defaultFee" class="col-sm-3 col-form-label">기본 배달 요금</label>
              <div class="col-sm-9">
              </div>
            </div>
            <div class="form-group row">
              <label for="fee1" class="col-sm-5 col-form-label"> 30000원 ~ 50000원 미만</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control-plaintext" id="fee1" value="1000원">
              </div>
            </div>
             <div class="form-group row">
              <label for="fee2" class="col-sm-5 col-form-label">15000원 ~ 30000원 미만</label>
              <div class="col-sm-7">
                <input type="text" readonly class="form-control-plaintext" id="fee2" value="2000원">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        배달 요금
      </div>
      <div class="card-body">
      <div class="row justify-content-center">
          <div class="col-5">
            <div class="form-group row">
              <label for="storeName" class="col-sm-3 col-form-label">총 주문 횟수:</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="storeName" value="교촌치킨 정자점">
              </div>
            </div>
          </div>
           <div class="col-5">
            <div class="form-group row">
              <label for="storeName" class="col-sm-3 col-form-label">1달 간 주문 횟수:</label>
              <div class="col-sm-9">
                <input type="text" readonly class="form-control-plaintext" id="storeName" value="교촌치킨 정자점">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
     <div class="card">
      <div class="card-header">
        위치 정보
      </div>
      <div class="card-body">
       <div class="row justify-content-center">
         <div class="col-10">
          <div class="form-group row">
                <label for="address" class="col-sm-3 col-form-label">주소</label>
                <div class="col-sm-9">
                  <input type="text" readonly class="form-control-plaintext" id="address" value="경기도 성남시 분당구 정자동 17-5 1층일부(정자동, 시그마타워)">
                </div>
              </div>
              <div class="form-group row">
                <label for="location" class="col-sm-3 col-form-label">배달 지역</label>
                <div class="col-sm-9">
                  <input type="text" readonly class="form-control-plaintext" id="location" value="정자동, 수내동, 금곡동">
                </div>
              </div>
              <div class="form-group row">
                <label for="dest" class="col-sm-3 col-form-label">나와의 거리</label>
                <div class="col-sm-9">
                  <input type="text" readonly class="form-control-plaintext" id="dest" value="3.8 km">
                </div>
              </div>
          </div>
        <div class="col-10 m-4">
          <div id="map" style="height:400px;">
          </div>
        </div>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
     initMap () {
      const container = document.getElementById('map');
      const options = {
        center: new kakao.maps.LatLng(35.19656853772262, 129.0807270648317),
        level: 3
      }
      const map = new kakao.maps.Map(container, options)
      // const markerPosition = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);

      // const marker = new kakao.maps.Marker({
      //   position: markerPosition
      // });
      // marker.setMap(map)
  },
  },
   mounted() {
     if (window.kakao && window.kakao.maps) {
        this.initMap();
      } else {
        const script=document.createElement('script');
        script.onload=()=>kakao.maps.load(this.initMap);
        script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b6cbac052860ed6350771411150f7480';
        document.head.appendChild(script);
      }
  },
  
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

</style>
