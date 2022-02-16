<template>
  <form class="pt-3 g-3 needs-validation" novalidate>
    <div class="py-3 row">
      <label for="username" class="col-sm-2 col-form-label">아이디</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="username" required />
      </div>
    </div>
    <div class="py-3 row d-grid gap-3 d-md-flex justify-content-md-center">
      <button
        class="submit-button d-grid gap-3 col-6 mx-auto"
        id="pw-modal-button"
        @click="checkForm"
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
      name: "",
      error: { name: [] },
    };
  },
  mounted() {
    console.log("FindIdModal");
  },
  methods: {
    // checkForm(e) {
    //   e.preventDefault();
    //   var forms = document.querySelectorAll(".needs-validation");
    //   forms.forEach((form) => {
    //     console.log(form);
    //     if (!form.checkValidity()) {
    //       e.preventDefault();
    //       e.stopPropagation();
    //     }
    //     form.classList.add("was-validated");
    //   });
    //   scrollTo(0, 0);
    // },
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
