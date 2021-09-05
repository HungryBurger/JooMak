<template>
  <div id="address-config-component" @click="onClickAddressConfigComponent">
    <div
      class="address-config_left"
      :class="{ 'on-home': onHome, 'out-home': !onHome }"
    >
      <img
        id="icon_address-config_home"
        src="@/assets/images/icon_home.svg"
        alt="icon_address-config_home"
        v-if="onHome"
      />
      <div v-else-if="!onHome">현재 주소</div>
    </div>
    <div class="address-config_middle">
      <!-- 서울특별시 강남구 논현동 123-45 -->
      {{ selectedAddress }}
    </div>
    <div
      class="address-config_right"
      :class="{ 'on-home': onHome, 'out-home': !onHome }"
    >
      <svg
        id="icon_address-config_reload"
        width="182"
        height="250"
        viewBox="0 0 182 250"
        fill="#bbbbbb"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M90.9598 56.8182V90.9091L136.44 45.4545L90.9598 0V34.0909C40.7045 34.0909 0 74.7727 0 125C0 142.841 5.23019 159.432 14.0988 173.409L30.6989 156.818C25.5824 147.386 22.74 136.477 22.74 125C22.74 87.3864 53.3252 56.8182 90.9598 56.8182ZM167.821 76.5909L151.221 93.1818C156.223 102.727 159.18 113.523 159.18 125C159.18 162.614 128.594 193.182 90.9598 193.182V159.091L45.4799 204.545L90.9598 250V215.909C141.215 215.909 181.92 175.227 181.92 125C181.92 107.159 176.689 90.5682 167.821 76.5909V76.5909Z"
        />
      </svg>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState("common", ["onHome"]),
    ...mapState("member", ["currentAddress"]),
    selectedAddress() {
      if (!this.currentAddress) return "주소를 설정해 주세요.";
      else return this.currentAddress;
    },
  },
  methods: {
    onClickAddressConfigComponent() {
      if (this.onHome) {
        // 주소 설정 Modal 열기
      } else if (!this.onHome) {
        alert("주소는 홈 화면에서 설정할 수 있습니다.");
      }
    },
  },
};
</script>

<style scoped>
#address-config-component {
  cursor: pointer;
  border-radius: 10px;
  display: flex;
  justify-content: space-between;
  width: 100%;
  height: 30px;
  background-color: white;
}
.address-config_left,
.address-config_middle,
.address-config_right {
  display: flex;
  justify-content: center;
  align-items: center;
}
.address-config_left.on-home,
.address-config_right.on-home {
  width: 10%;
  height: 30px;
}
.address-config_middle {
  color: #292929;
  font-weight: bold;
  width: 80%;
  height: 30px;
  overflow: hidden;
}
.address-config_left.out-home {
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
  width: 105px;
  height: 30px;
  font-size: 14px;
  font-weight: bold;
  background-color: #ffd389;
  color: white;
}
.address-config_middle.out-home {
  width: 100%;
}
.address-config_right.out-home {
  display: none;
}

#icon_address-config_home {
  width: 20px;
  height: auto;
}
.address-config_right svg {
  width: 14px;
  height: auto;
  transition: 0.4s;
}
#address-config-component:hover .address-config_right svg {
  transform: rotateZ(180deg);
  fill: #292929;
}
</style>
