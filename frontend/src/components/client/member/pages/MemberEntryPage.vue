<template>
  <div class="register-page">
    <div class="register-page-wrap">
      <div class="title">
        <img
          class="login-logo"
          src="@/assets/images/JoomakLogo_login.svg"
          alt="JoomakLogo"
        />
        <h1>
          회원가입
        </h1>
      </div>
      <div class="row justify-content-center">
        <form class="col-6 g-3 needs-validation" novalidate>
          <div class="py-3">
            <label for="username" class="form-label"
              >아이디<span class="require-test">*</span></label
            >
            <div class="input-group">
              <input
                type="text"
                class="form-control"
                id="username"
                v-model="username"
                maxlength="20"
                required
              />

              <button class="input-button" @click="checkId">
                &nbsp;&nbsp; 중복 체크 &nbsp;&nbsp;
              </button>
              <div class="invalid-feedback">
                아이디를 입력하세요.
              </div>
            </div>
          </div>
          <div class="py-3">
            <label for="password" class="form-label"
              >비밀번호<span class="require-test">*</span></label
            >
            <input
              type="text"
              class="form-control"
              id="password"
              v-model="password"
              maxlength="20"
              required
            />
            <div class="invalid-feedback">
              비밀번호를 입력하세요.
            </div>
          </div>
          <div class="py-3">
            <label for="password-confirm" class="form-label"
              >비밀번호 확인<span class="require-test">*</span></label
            >
            <input
              type="text"
              class="form-control"
              id="password-confirm"
              v-model="password_confirm"
              maxlength="20"
              required
              @blur="checkPassword"
            />
            <div class="invalid-feedback">
              비밀번호를 입력하세요.
            </div>
            <div class="custom-invalid " v-if="!passwordCheckFlag"> 비밀번호가 동일하지 않습니다. </div>

          </div>
          <div class="py-3">
            <label for="name" class="form-label"
              >이름<span class="require-test">*</span></label
            >
            <input
              type="text"
              class="form-control"
              id="name"
              v-model="name"
              maxlength="4"
              required
            />
            <div class="invalid-feedback">
              이름을 입력하세요.
            </div>
          </div>
          <div class="py-3">
            <label for="email" class="form-label"  maxlength="20"
              >이메일<span class="require-test">*</span></label
            >
            <div class="input-group mb-3">
              <input
                type="text"
                class="form-control"
                placeholder="Username"
                aria-label="Username"
                required
              />
              <span class="input-group-text">@</span>
              <select id="email-back" class="form-select" required>
                <option value="" selected>Choose...</option>
                <option value="naver.com">naver.com</option>
                <option value="gmail.com">gmail.com</option>
              </select>
              <button class="input-button">인증번호 요청</button>
              <div class="invalid-feedback">
                이메일을 입력하세요.
              </div>
            </div>
            <div class="input-group">
              <input
                type="text"
                class="form-control"
                id="email-confirm"
                placeholder="인증번호 입력"
                maxlength="10"
                v-model="email_confrim"
                required
              />
              <button class="input-button">인증번호 확인</button>
              <div class="invalid-feedback">
                인증번호를 입력하세요.
              </div>
            </div>
          </div>
          <div class="py-3">
            <label for="phone" class="form-label"
              >휴대폰 번호<span class="require-test">*</span></label
            >
            <div class="input-group mb-3">
              <input
                type="text"
                id="phone-front"
                class="form-control"
                placeholder="010"
                value="010"
                required
              />
              <span class="input-group-text">-</span>
              <input
                type="text"
                class="form-control"
                id="phone-middle"
                maxlength="4"
                required
              />
              <span class="input-group-text">-</span>
              <input
                type="text"
                class="form-control"
                id="phone-back"
                maxlength="4"
                required
              />
              <div class="invalid-feedback">
                휴대폰 번호를 입력하세요.
              </div>
            </div>
          </div>
        </form>
        <div class="additional py-3 mb-3">
          추가 정보
        </div>
        <form class="col-6 g-3">
          <div class="py-3">
            <label for="name" class="form-label">생년월일</label>
            <div class="input-group">
              <select id="year" class="form-select" placeholder="2021">
                <option selected>Choose...</option>
              </select>
              <span class="input-group-text">년</span>
              <select id="month" class="form-select" placeholder="2021">
                <option selected>Choose...</option>
              </select>

              <span class="input-group-text">월</span>
              <select id="day" class="form-select" placeholder="2021">
                <option selected>Choose...</option>
              </select>

              <span class="input-group-text">일</span>
            </div>
          </div>
          <div class="py-3">
            <label for="nickname" class="form-label">별명</label>
            <input
              type="text"
              class="form-control"
              id="nickname"
              v-model="nickname"
            />
          </div>
          <div class="py-3">
            <label for="gender" class="form-label">성별</label>
            <div class="input-group mb-3">
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="radio"
                  name="inlineRadioOptions"
                  id="inlineRadio1"
                  value="option1"
                />
                <label class="form-check-label" for="inlineRadio1">1</label>
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="radio"
                  name="inlineRadioOptions"
                  id="inlineRadio2"
                  value="option2"
                />
                <label class="form-check-label" for="inlineRadio2">2</label>
              </div>
            </div>
          </div>
          <div class="d-grid gap-3 d-md-flex justify-content-md-center">
            <router-link
              class="back-button d-grid gap-3 col-6 mx-auto"
              to="/member/login"
              >돌아가기
            </router-link>
            <button
              class="submit-button d-grid gap-3 col-6 mx-auto"
              @click="checkForm"
            >
              회원가입
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      errors: {
        username: "",
        password: "",
        password_confirm: "",
        name: "",
        phone: "",
      },
      username: "",
      password: "",
      password_confirm: "",
      name: "",
      email: "",
      email_confirm: "",
      phone: "",
      birth: "",
      nickname: "",
      gender: "",
      passwordCheckFlag:true
    };
  },
  methods: {
    checkForm(e) {
      e.preventDefault();
      var forms = document.querySelectorAll(".needs-validation");
      forms.forEach((form) => {
        console.log(form);
        if (!form.checkValidity()) {
          e.preventDefault();
          e.stopPropagation();
        }
        form.classList.add("was-validated");
      });
      scrollTo(0, 0);
    },
    checkId(id) {
      //중복확인

    },
    checkPassword() {
      if (this.password === this.password_confirm) {
         this.passwordCheckFlag = true 
      } else {
          this.passwordCheckFlag = false 
        }
    },
     async handleSendEmail() {
      try {
          // 1. 이메일 전송 요청
        axios
          .get("/verifyEmail?key=?",
          {
            email: this.email,
            returnSecureToken: true,
          }) // 임시 url로 요청. 추후 수정 예정
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
          // 2. Input 상태 변경
          // 3. Button 상태 변경
          // 4. Button 텍스트 변경
          // 5. emit
        } catch (error) {
          //...
      }
    },
    signup(){
       const formData = {
          username: this.email,
          password: this.password,
          password_confirm: this.password_confirm,
          name: this.name,
          email: this.email,
          email_confirm: this.email_confirm,
          phone: this.phone,
          birth: this.birth,
          nickname: this.nickname,
          gender: this.gender,
        }
        console.log(formData)
        this.$store.commit(`member/${SIGN_UP}`, {
              index: i,
              inputText: this.input,
        });
    }
    
   /*  async save() {
      const validate = this.$refs.form.validate();
      if (validate) {
        if (confirm ('저장하시겠습니까?')) {
          const params = {
            user_id: this.user_id,
            user_nm: this.user_nm,
            user_pw: this.user_pw,
            user_auth_code: this.user_auth.value,
            user_auth_nm: this.user_auth.name,
            user_desc: this.user_desc
          }
          if (this.state == 'upd') {
            params._id = this.user_info._id;
            params.user_mk_dt = this.user_info.user_mk_dt;
  
          }
          try {
            const url = (this.state == 'ins' ? 'setting/user/insertUser' : 'setting/user/updateUser');
            const rs = await this.$store.dispatch(url, params);
            if (rs.data.result.error == false) {
              this.$store.dispatch('setting/user/initUserList');
              this.close();
            }
          } catch (err) {
            alert(err);
          }
        }
      }
    }, */
  },
};
</script>
<style scoped>
input[type="radio"] {
  background-color: #ffffff;
  border: 1px solid #c0c0c0;
}
input[type="radio"]:checked {
  background-color: #ffc463;
}
.require-test {
  color: #ffc463;
  font-size: 18px;
  padding-left: 4px;
}
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
.back-button {
  outline: 0;
  background: #ffc463;
  border-radius: 5px;
  border: 0;
  color: #ffffff;
  text-align: center;
  padding: 12px;
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
.register-page {
  margin: 0;
  background-color: #fff0b1;
}
.login-logo {
  width: 180px;
  padding: 24px;
}
.register-page-wrap {
  z-index: 1;
  background: #ffffff;
  height: 2000px;
  margin: 0px 120px;
  padding: 24px;
}
.title {
  text-align: center;
}
.form input,
.form select {
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  padding: 12px;
  box-sizing: border-box;
  /* font-size: 12px; */
  border-radius: 5px;
}
.additional {
  text-align: center;
  color: #828282;
  border-bottom: 3px solid #ffc463;
  /* text-decoration: underline #ffc463; */
  font-size: 18px;
  width: 55%;
}
.custom-invalid{
  width: 100%;
  margin-top: 0.25rem;
  font-size: .875em;
  color: #dc3545;
}
</style>
