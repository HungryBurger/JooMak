<template>
  <div class="login-page">
    <div class="form">
      <img
        class="login-logo"
        src="@/assets/images/JoomakLogo_login.svg"
        alt="JoomakLogo"
      />
      <h1>
        Login
      </h1>
      <form class="login-form">
        <input
          class="form-control"
          id="username"
          type="text"
          placeholder="username"
          required
        />

        <input
          type="text"
          class="form-control"
          id="password"
          placeholder="password"
          required
        />
        <button class="submit-button" type="submit">login</button>
        <div class="row c-btn-group c-btn-group--block">
          <router-link class="col-6 c-btn right-line" to="/member/entry"
            >회원가입
          </router-link>

          <a class="col-6 c-btn" type="button" @click="openModal"
            >아이디/비밀번호 찾기</a
          >
          <ModalComponent @close="closeModal" v-if="onModal">
            <template v-slot:header>
              <h1>아이디/비밀번호 찾기</h1>
              <hr />
            </template>
            <template v-slot:content>
              <div class="find_modal_content">
                <find-modal></find-modal>
              </div>
            </template>
            <template v-slot:footer>
              <div class="no-use"></div>
            </template>
          </ModalComponent>
          <!-- <a class="c-btn" @click="openModal">비밀번호 찾기</a> -->
        </div>
      </form>
      <div class="social-login-form">
        <p>소셜 로그인(SNS 로그인)</p>
        <div class="btn-group">
          <button class="btn-primary">Naver Login</button>
          <button class="btn-primary">GOogle Login</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import FindModal from "./FindModal.vue";
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import { SET_ON_MODAL } from "@/store/modules/common.js";
export default {
  components: { FindModal, ModalComponent },
  computed: {
    ...mapState("common", ["onModal"]),
  },
  methods: {
    openModal() {
      this.$store.commit(`common/${SET_ON_MODAL}`, true); // 주6.
    },
    closeModal() {
      console.log("close event 발생"); // 주7.
    },
  },
};
</script>

<style scoped>
.submit-button {
  text-transform: uppercase;
  outline: 0;
  background: #ffc463;
  border-radius: 5px;
  /* width: 60%; */
  border: 0;
  padding: 12px;
  color: #ffffff;
  /* font-size: 12px; */
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.find_modal_content {
  margin: 36px;
}

.form-group {
  display: flex;
  flex-direction: row;
  padding: 20px;
  width: 70%;
  margin: 0 auto;
}

.form-group label {
  flex: none;
  display: block;
  /* font-weight: bold; */
  font-size: 1em;
  text-align: left;
  padding: 12px;
  /* width: 7em; */
  margin-right: 0.5em;
}
.form-group label.right-inline {
  text-align: right;
  padding-right: 8px;
  padding-left: 10px;
  /* width: auto; */
}

.form-group .input-control {
  flex: 1 1 auto;
  display: block;
  margin-bottom: 10px;
  margin-right: 8px;
  padding: 4px;
  margin-top: -4px;
  width: 60%;
}

button {
  width: 60%;
  padding: 5px 15px;
  /* min-width: 100px; */
}

.btn {
  position: relative;
  vertical-align: top;
  height: 40px;
  width: 25%;
  padding: 0;
  font-size: 15px;
  color: #fff;
  text-align: center;
  background: #4d4d4d;
  border: 0;
  border-bottom: 2px solid #d0d0d0;
  cursor: pointer;
  margin-left: auto;
}
a {
  text-decoration-line: none;
}
.c-btn {
  padding: 0.25em 0.5em;
  border: solid 1px black;
  border-radius: 4px;
  display: inline-block;
  text-align: center;
}
.c-btn:hover,
.c-btn:focus {
  cursor: pointer;
  background-color: #eeeeee;
  color: #fff;
}
.c-btn-group {
  margin-top: 32px;
  display: inline-flex;
  color: #828282;
  overflow: hidden;
}
.c-btn-group--block {
  display: flex;
}
.c-btn-group--block > .c-btn {
  flex-grow: 1;
}
.c-btn-group > .c-btn {
  color: #828282;
  border-radius: 0;
  border: none;
}
.c-btn-group > .right-line {
  border-right: 1px solid #828282;
}
h1 {
  font-size: 24px;
}
.social-login-form {
  margin: 32px auto;
  width: 60%;
  text-align: left;
}
.social-login-form > p {
  margin: 12px;
  color: #828282;
}
.btn-group {
  overflow: hidden;
  display: flex;
}
.btn-group > .btn-primary {
  border-radius: 5px;
  background: #ffc463;
  flex-grow: 1;
  margin: 12px;
}
.btn-group > .btn-primary:nth-child(1) {
  background: #2ecc71;
}
.btn-group > .btn-primary:nth-child(2) {
  background: #ff5a58;
}
.login-page {
  /* margin: 0; */
  background-color: #fff0b1;
  width: 100%;
  height: 100vh;
  position: fixed;
}
.login-logo {
  width: 180px;
  padding: 24px;
}
.form {
  z-index: 1;
  background: #ffffff;
  height: 2000px;
  margin: 0px 120px;
  padding: 24px;
  text-align: center;
}
.login-form {
  position: relative;
  max-width: 540px;
  margin: 0 auto;
  padding: 32px;
  text-align: center;
}
.form input {
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 24px;
  padding: 12px;
  box-sizing: border-box;
  border-radius: 5px;
}
.form button {
  text-transform: uppercase;
  outline: 0;
  background: #ffc463;
  border-radius: 5px;
  width: 100%;
  border: 0;
  padding: 12px;
  color: #ffffff;
  /* font-size: 12px; */
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,
.form button:active,
.form button:focus {
  /* background: #43a047; */
}
</style>
