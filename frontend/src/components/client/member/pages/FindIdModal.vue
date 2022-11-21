<template>
  <form @submit.prevent class="pt-3 g-3 needs-validation" novalidate>
    <div class="py-3 row">
      <label for="name" class="col-sm-2 col-form-label">이름</label>
      <div class="col-sm-10">
        <input v-model="localName" type="text" class="form-control" id="name" required />
      </div>
    </div>
    <div class="py-3 row">
      <label for="email" class="col-sm-2 col-form-label">이메일</label>
      <div class="col-sm-10">
        <div class="input-group">
          <input v-model="localEmail" type="text" class="form-control" id="email" required />
          <button class="input-button">인증번호 발송</button>
        </div>
      </div>
    </div>
    <div class="py-3 row">
      <label for="email-confirm" class="col-sm-2 col-form-label"
        >인증 번호</label
      >
      <div class="col-sm-10">
        <input
          type="text"
          class="form-control"
          id="email-confirm"
          placeholder="인증번호 입력"
          v-model="emailConfirmNum"
          required
        />
      </div>
    </div>
    <div class="py-3 row d-grid gap-3 d-md-flex justify-content-md-center">
      <button
        class="submit-button d-grid gap-3 col-6 mx-auto"
        @click="checkForm()"
      >
        확인
      </button>
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      localName: "",
      localEmail: "",
      emailConfirmNum: "",
      error: { name: [] },
    };
  },
  methods: {
    checkForm() {
      let flag = true
      var forms = document.querySelectorAll(".needs-validation");
      forms.forEach((form) => {
        form.classList.add("was-validated");
      })
      if(!(this.localName && this.localEmail && this.emailConfirmNum)) {
        scrollTo(0, 0);
        flag = false
      }
      return flag
    },
    submit() {
      if(!this.checkForm()) return

      // else --> ID찾기 API 사용
    }
  },
};
</script>

<style scoped>
.input-button {
  text-transform: uppercase;
  outline: 0;
  z-index: 1;
  background: #ffffff;
  border-radius: 5px;
  border: 3px solid #ffc463;
  color: #ffc463;
  /* font-size: 12px; */
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
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
</style>
