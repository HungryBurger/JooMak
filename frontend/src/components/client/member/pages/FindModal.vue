<template>
  <!-- <div class="find-modal">
    <div class="find-modal-wrap"> -->
  <div class="row justify-content-center">
    <div class="find-modal-from">
      <nav>
        <div class="nav nav-tabs nav-justified" id="nav-tab" role="tablist">
          <button
            class="nav-link active"
            id="nav-home-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-home"
            type="button"
            role="tab"
            aria-controls="nav-home"
            aria-selected="true"
          >
            아이디 찾기
          </button>
          <button
            class="nav-link"
            id="nav-profile-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-profile"
            type="button"
            role="tab"
            aria-controls="nav-profile"
            aria-selected="false"
          >
            비밀번호 찾기
          </button>
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div
          class="tab-pane fade show active"
          id="nav-home"
          role="tabpanel"
          aria-labelledby="nav-home-tab"
        >
          <find-id-modal />
        </div>
        <div
          class="tab-pane fade"
          id="nav-profile"
          role="tabpanel"
          aria-labelledby="nav-profile-tab"
        >
          <find-pw-modal />
        </div>
      </div>
    </div>
  </div>
  <!-- </div>
  </div> -->
</template>

<script>
import FindIdModal from "./FindIdModal.vue";
import FindPwModal from "./FindPwModal.vue";
export default {
  components: { FindIdModal, FindPwModal },
};
</script>

<style scoped>
/* .find-modal-wrap {
  z-index: 1;
  background: #ffffff;
  height: 2000px;
  margin: 0px 120px;
  padding: 24px;
}
.find-modal {
  margin: 0;
  background-color: #fff0b1;
} */
</style>
