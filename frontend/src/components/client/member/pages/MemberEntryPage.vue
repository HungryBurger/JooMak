<template>
  <div class="register-page">
    <div class="register-page-wrap">
      <div class="title">
        <h1>
          회원가입
        </h1>
      </div>
      <div class="row justify-content-center">
        <form
          class="col-6 g-3 needs-validation"
          novalidate
          @submit.prevent
        >
          <ul>
            <li>
              <div class="py-3">
                <label for="name" class="form-label">
                  이름<span class="require-test">*</span>
                </label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  v-model="name"
                  maxlength="6"
                  required
                />
                <div class="invalid-feedback">
                  이름을 입력하세요.
                </div>
              </div>
            </li>
            <li>
              <div class="py-3">
                <label for="email" class="form-label"  maxlength="20">
                  이메일<span class="require-test">*</span>
                </label>
                <div class="input-group mb-3">
                  <input
                    v-model="emailFront"
                    type="text"
                    class="email-form form-control"
                    placeholder="joomo123"
                    aria-label="Username"
                    id="email-front"
                    required
                  />
                  <span class="input-group-text">@</span>
                  <select v-model="emailBack" id="email-back" class="email-form form-select" required>
                    <option value="" selected>선택해주세요.</option>
                    <option value="naver.com">naver.com</option>
                    <option value="gmail.com">gmail.com</option>
                  </select>
                  <!-- <button class="input-button" id="email-send-button" @click="handleSendEmail">인증번호 요청</button> -->
                  <div class="invalid-feedback">
                    이메일을 입력하세요.
                  </div>
                </div>
              </div>
            </li>
            <li>
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
            </li>
            <li>
              <div class="py-3">
                <label for="password-confirm" class="form-label">
                  비밀번호 확인<span class="require-test">*</span>
                </label>
                <input
                  type="text"
                  class="form-control"
                  id="password-confirm"
                  v-model="passwordConfirm"
                  maxlength="20"
                  required
                  @blur="checkPassword"
                />
                <div class="invalid-feedback">
                  비밀번호를 입력하세요.
                </div>
                <div class="custom-invalid " v-if="!passwordCheckFlag">비밀번호가 동일하지 않습니다.</div>
              </div>
            </li>
            <li>
              <div class="py-3 address-wrap">
                <label>주소<span class="require-test">*</span>
                  <span>(최대 4개까지 추가 가능)</span>
                </label>
                <div class="btn-wrap">
                  <button @click="addAddressInfo">추가</button>
                  <button @click="removeAddressInfo">제거</button>
                </div>
                <div class="input-group mb-3">
                  <div v-for="(addressInfo, i) in addressCreateInfoList" :key="i" class="address-input-box">
                    <div>
                      <label :for="`city_${i}`">지역</label><br />
                      <input class="form-control" type="text" :name="`city_${i}`" v-model="addressInfo.city" placeholder="서울특별시">
                    </div>
                    <div>
                      <label :for="`postCode_${i}`">우편번호</label><br />
                      <input class="form-control" type="number" :name="`postCode_${i}`" v-model="addressInfo.postCode" placeholder="12345">
                    </div>
                    <div>
                      <label :for="`street_${i}`">상세주소</label><br />
                      <input class="form-control" type="text" :name="`street_${i}`" v-model="addressInfo.street" placeholder="부흥로 123번길 2, 1동 101호">
                    </div>
                  </div>
                </div>
              </div>
            </li>
          </ul>

          <div class="additional py-3 mb-3">
            추가 정보
          </div>
          <ul>
            <li>
              <div class="py-3">
                <label class="form-label">생년월일
    
                </label>
                <div class="input-group">
                  <select v-model="chosenYear" id="year" class="form-select">
                    <option disabled value="">Choose...</option>
                    <option
                      v-for="(year, idx) in years"
                      :value="year"
                      :key="idx"
                    >{{ year }}</option>
                  </select>
                  <span class="input-group-text">년</span>
    
                  <select v-model="chosenMonth" id="month" class="form-select">
                    <option disabled value="">Choose...</option>
                    <option
                      v-for="(month, idx2) in months"
                      :value="month"
                      :key="idx2"
                    >{{ month }}</option>
                  </select>
                  <span class="input-group-text">월</span>
    
                  <select v-model="chosenDay" id="day" class="form-select">
                    <option disabled value="">Choose...</option>
                    <option
                      v-for="(day, idx3) in days"
                      :key="idx3"
                      :value="day"
                    >{{ day }}</option>
                  </select>
                  <span class="input-group-text">일</span>
                </div>
              </div>
            </li>
            <li>
              <div class="py-3">
                <label for="nickname" class="form-label">닉네임</label>
                <input
                  type="text"
                  class="form-control"
                  id="nickname"
                  v-model="nickname"
                  placeholder="lovely철수"
                />
              </div>
            </li>
            <li>
              <div class="py-3">
                <label for="gender" class="form-label">성별</label>
                <div class="input-group mb-3">
                  <div class="form-check form-check-inline">
                    <input
                      v-model="gender"
                      class="form-check-input"
                      type="radio"
                      name="male"
                      id="inlineRadio1"
                      value="MALE"
                    />
                    <label class="form-check-label" for="male">남</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input
                      v-model="gender"
                      class="form-check-input"
                      type="radio"
                      name="female"
                      id="inlineRadio2"
                      value="FEMALE"
                    />
                    <label class="form-check-label" for="female">여</label>
                  </div>
                </div>
              </div>
            </li>
          </ul>
          <div class="d-grid gap-3 d-md-flex justify-content-md-center">
            <router-link
              class="back-button d-grid gap-3 col-6 mx-auto"
              to="/member/login"
              >돌아가기
            </router-link>
            <button
              class="submit-button d-grid gap-3 col-6 mx-auto"
              @click.prevent="checkForm"
            >
              회원가입
            </button>
          </div>
        </form>
      </div>
      <ConfirmModal
        message="입력하신 정보로 회원가입 신청하시겠어요?"
        :condition="showConfirmModalSignUp"
        @confirm-yes="confirmYesSignUp"
        @confirm-no="confirmNoSignUp"
      />
    </div>
  </div>
</template>

<script>
import DateUtil from "@/utils/DateUtil.js";
import ConfirmModal from "@/components/client/common/share/components/ConfirmModal.vue";
import {getMembers, memberEntry} from "@/api/mbrm/index.js";

export default {
  components: {
    ConfirmModal
  },
  data() {
    return {
      errors: {
        username: "",
        password: "",
        passwordConfirm: "",
        name: "",
        phone: "",
      },
      username: "",
      name: "",
      emailFront: "",
      emailBack: "",
      // email_authcode: "",
      password: "",
      passwordConfirm: "",
      addressCreateInfoList: [{
        city: '',
        postCode: '00000',
        street: ''
      }],
      phone: "",
      chosenYear: "",
      chosenMonth: "",
      chosenDay: "",
      nickname: "",
      gender: "",
      passwordCheckFlag:true,

      showConfirmModalSignUp: false,
      years: [
        '1990',
        '1991',
        '1992',
        '1993',
        '1994',
        '1995',
        '1996',
        '1997',
        '1998',
        '1999',
        '2000',
        '2001',
        '2002',
        '2003',
        '2004',
        '2005',
      ],
      months: ['1','2','3','4','5','6','7','8','9','10','11','12']
    };
  },
  computed: {
    email() {
      return this.emailFront + '@' + this.emailBack;
    },
    days() {
      let days = []
      if(this.chosenYear && this.chosenMonth) {
        days = DateUtil.getDayListOfMonth(`${this.chosenYear}-${this.chosenMonth}`)
      }
      return days
    },
    birth() {
      let birth = "";
      if(this.chosenYear && this.chosenMonth && this.chosenDay) {
        birth =
          `${this.chosenYear}-${this.chosenMonth.length < 2 ? '0'+this.chosenMonth : this.chosenMonth}-${this.chosenDay.length < 2 ? '0'+this.chosenDay : this.chosenDay}`
      }
      return birth
    }
  },
  watch: {
    chosenMonth(newVal, oldVal) {
      if(newVal!=='' && !this.chosenYear) {
        alert('먼저 연도를 선택해 주세요.');
        this.chosenMonth = oldVal;
      }
    }
  },
  created() {
    this.getAllMembers()  // Test. 모든회원 조회.
  },
  methods: {
    async getAllMembers() {
      const data = await getMembers();
      console.log(data);
    },
    getYMS(yms) {
      return DateUtil.getYMS(yms)
    },
    addAddressInfo() {
      if(this.addressCreateInfoList.length < 4) {
        this.addressCreateInfoList.push({
          city: '',
          postCode: '00000',
          street: ''
        });
      }
    },
    removeAddressInfo() {
      if(this.addressCreateInfoList.length > 1) {
        this.addressCreateInfoList.splice(this.addressCreateInfoList.length - 1, 1);
      }
    },
    checkForm() {
      var forms = document.querySelectorAll(".needs-validation");
      forms.forEach((form) => {
        console.log(form);
        form.classList.add("was-validated");
        if (!form.checkValidity()) {
          var inputNodeList = form.querySelectorAll("input");
          var inputs = Object.values(inputNodeList);
          var invalidInputs = inputs.filter((input) => !(input.validity.valid));
          invalidInputs.forEach((el) => {
            console.log(el);
            // console.log(el.validity);
          });
          invalidInputs[0].focus;
          var absoluteTop = window.pageYOffset + invalidInputs[0].getBoundingClientRect().top;
          scrollTo(0, absoluteTop - window.innerHeight * 0.18);
        } else {
          this.showConfirmModalSignUp = true;
        }
      });
    },
    checkPassword() {
      if (this.password === this.passwordConfirm) {
        this.passwordCheckFlag = true 
      } else {
          this.passwordCheckFlag = false 
        }
    },
    handleSendEmail(e) {
      e.preventDefault();
          // 1. 이메일 전송 요청
          const returnToken=true;

          // 2. Input 상태 변경
          if(returnToken===true){
            
          
          // 3. Button 상태 변경
          const emailBtn = document.querySelector('#email-send-button') //id가 'btn'인 요소를 반환한다.
          const emailInput = document.querySelector('.email-form') //id가 'btn'인 요소를 반환한다.
            emailInput.disabled = true;
          // 4. Button 텍스트 변경
            emailBtn.innerText = '재전송'  // 텍스트를 unfollow로 변경
          }
          // 5. emit
          
    },
    handleSendAuthCode(e) {
      e.preventDefault();
       // 1. 인증번호 확인전송 요청
          const returnToken=true;

          // 2. Input 상태 변경
          if(returnToken===true){
            
          
          // 3. Button 상태 변경
          const authcodeBtn = document.querySelector('#authcode-send-button') //id가 'btn'인 요소를 반환한다.
          // 4. Button 텍스트 변경
          const authcodeSuccessToken=true;
          if(authcodeSuccessToken===true)
            authcodeBtn.innerText = '인증완료'  // 텍스트를 unfollow로 변경
          }

    },
    /*  async handleSendEmail() {
      try {
          // 1. 이메일 전송 요청
        axios
          .get("/verifyEmail?key=?",
          {
            email: this.email,
           // returnSecureToken: true,
          }) // 임시 url로 요청. 추후 수정 예정
          .then((res) => {
          // 2. Input 상태 변경
          if(res.returnToken===true){
            
          }
          // 3. Button 상태 변경
          emailSendSuccess=true;
          // 4. Button 텍스트 변경
          // 5. emit
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
      
        } catch (error) {
          //...
      }
    }, */
    async signup(){
      const params = {
        addressCreateInfoList: this.addressCreateInfoList,
        name: this.name,
        email: this.email,
        password: this.password,
        birth: this.birth,
        nickname: this.nickname,
        gender: this.gender,
        role: "USER",
        snsLoginYn: false,
        grade: "BRONZE",
        lastLoginedAt: DateUtil.getUTCinSeoul().format().slice(0, -6), // 원래 마지막 로그인시간이 들어가야함. 임시로 현재시각 넣음
        loginFailCount: 0,
        mobile: "string",
        profileImagePath: "string",
        state: "NORMAL"
      }
      
      try {
        const data = await memberEntry(params)
        console.log('회원가입 요청 결과: ', data)
        if(!data) return
        if(data.resultCd === 'S') {
          this.$router.push({
            path: 'entry-complete',
            params: {userName: this.name}
          })
        }
      } catch (e) {
        console.error(e)
      }
    },
    confirmYesSignUp() {
      this.signup();
      this.showConfirmModalSignUp = false;
    },
    confirmNoSignUp() {
      this.showConfirmModalSignUp = false;
    },
    
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
.input-group .address-input-box{
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 10px 10px 30px 10px;
  background-color: #fff0b1;
  width: 100%;
}
.address-wrap .btn-wrap {
  display: flex;
  flex-direction: row;
  justify-content: end;
  gap: 6px;
  margin-top: 0;
  margin-bottom: 10px;
}
.address-wrap .btn-wrap button {
  padding: 2px 14px;
  border: 1px solid black;
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
  height: fit-content;
  margin: 0 120px;
  padding: 100px 24px 200px 24px;
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
  width: 100%;
  margin-top: 50px;
}
.custom-invalid{
  width: 100%;
  margin-top: 0.25rem;
  font-size: .875em;
  color: #dc3545;
}
</style>
