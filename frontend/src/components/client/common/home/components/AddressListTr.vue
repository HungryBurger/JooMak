<template>
  <tr>
    <td rowspan="2">
      <div class="check-box_wrap">
        <img v-if="addressObj.selected" :src="imgPathSingleY" alt="checked" />
        <img v-else :src="imgPathSingleN" alt="unchecked" />
      </div>
    </td>
    <td rowspan="2">{{ addressObj.name }}</td>
    <td class="address_td address_main">{{ addressObj.addressMain }}</td>
    <td rowspan="2">
      <div>상세 주소 편집</div>
    </td>
    <td rowspan="2" class="close_td">
      <div class="icon_close_wrap">
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
    </td>
  </tr>
  <tr>
    <td class="address_td address_detail">
      <span v-if="!onChangeMode">{{ addressObj.addressDetail }}</span>
      <div v-else>
        <input type="text" />
        <div>확인</div>
        <div>취소</div>
      </div>
    </td>
  </tr>
</template>

<script>
export default {
  props: ["addressObj"],
  data() {
    return {
      onChangeMode: false,
    };
  },
  computed: {
    imgPathSingleY() {
      return require("@/assets/images/icon_check-only_y.svg");
    },
    imgPathSingleN() {
      return require("@/assets/images/icon_check-only_n.svg");
    },
  },
  // mounted() {
  //   console.log(this.addressObj);
  // },
};
</script>

<style></style>
