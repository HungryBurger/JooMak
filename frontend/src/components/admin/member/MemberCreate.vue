<template>
  <div class="member-create-container">
    <div class="member-create-wrap">
      <h6>회원 Mockup {{ mode === 'create' ? 'Create' : 'Update' }}</h6>
      <form @submit.prevent>
        <ul>
          <li>
            <div>
              <label for="email">E-Mail</label>
              <input type="text" name="email" v-model="email" placeholder="hello123@gmail.com">
            </div>
          </li>
          <li>
            <div>
              <label for="password">비밀번호</label>
              <input type="text" name="password" v-model="password">
            </div>
          </li>
          <li>
            <div>
              <label for="name">이름 (name)</label>
              <input type="text" name="name" v-model="name" placeholder="김철수">
            </div>
          </li>
          <li>
            <div>
              <label for="nickname">닉네임 (nickname)</label>
              <input type="text" name="nickname" v-model="nickname" placeholder="lovely철수">
            </div>
          </li>
          <li>
            <div class="address-wrap">
              <span>주소 (addressCreateInfoList)</span>
              <div class="btn-wrap">
                <button @click="addAddressInfo">추가</button>
                <button @click="removeAddressInfo">제거</button>
              </div>
              <div class="address-input">
                <div v-for="(addressInfo, i) in addressCreateInfoList" :key="i" class="address-input-box">
                  <div>
                    <label :for="`city_${i}`">지역</label><br />
                    <input type="text" :name="`city_${i}`" v-model="addressInfo.city" placeholder="서울특별시">
                  </div>
                  <div>
                    <label :for="`postCode_${i}`">우편번호</label><br />
                    <input type="number" :name="`postCode_${i}`" v-model="addressInfo.postCode" placeholder="12345">
                  </div>
                  <div>
                    <label :for="`street_${i}`">상세주소</label><br />
                    <input type="text" :name="`street_${i}`" v-model="addressInfo.street" placeholder="부흥로 123번길 2, 1동 101호">
                  </div>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div>
              <label for="birth">생일 (birth)</label>
              <input type="text" name="birth" v-model="birth" placeholder="19970101">
            </div>
          </li>
          <li>
            <div class="gender-input">
              <span>성별 (gender)</span>
              <div>
                <div>
                  <input type="radio" name="male" value="MALE" v-model="gender">
                  <label for="male">남</label>
                </div>
                <div>
                  <input type="radio" name="female" value="FEMALE" v-model="gender">
                  <label for="female">여</label>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div class="snsLoginYn-input gender-input">
              <span>SNS로그인 여부 (snsLoginYn)</span>
              <div>
                <div>
                  <input type="radio" name="No" :value=false v-model="snsLoginYn">
                  <label for="No">No</label>
                </div>
                <div>
                  <input type="radio" name="Yes" :value=true v-model="snsLoginYn">
                  <label for="Yes">Yes</label>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div class="role-input">
              <span>Member유형 (role)</span>
              <div>
                <div>
                  <input type="radio" name="USER" value="USER" v-model="role">
                  <label for="USER">USER</label>
                </div>
                <div>
                  <input type="radio" name="OWNER" value="OWNER" v-model="role">
                  <label for="OWNER">OWNER</label>
                </div>
                <div>
                  <input type="radio" name="ADMINISTRATOR" value="ADMINISTRATOR" v-model="role">
                  <label for="ADMINISTRATOR">ADMINISTRATOR</label>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div class="grade-input">
              <span>등급 (grade)</span>
              <div>
                <div>
                  <input type="radio" name="BRONZE" value="BRONZE" v-model="grade">
                  <label for="BRONZE">BRONZE</label>
                </div>
                <div>
                  <input type="radio" name="SILVER" value="SILVER" v-model="grade">
                  <label for="SILVER">SILVER</label>
                </div>
                <div>
                  <input type="radio" name="GOLD" value="GOLD" v-model="grade">
                  <label for="GOLD">GOLD</label>
                </div>
                <div>
                  <input type="radio" name="VIP" value="VIP" v-model="grade">
                  <label for="VIP">VIP</label>
                </div>
              </div>
            </div>
          </li>
          <li>
            <div class="state-input">
              <span>회원 상태 (state)</span>
              <div>
                <div>
                  <input type="radio" name="GENERAL" value="GENERAL" v-model="state">
                  <label for="GENERAL">GENERAL</label>
                </div>
                <div>
                  <input type="radio" name="BANNED" value="BANNED" v-model="state">
                  <label for="BANNED">BANNED</label>
                </div>
              </div>
            </div>
          </li>
        </ul>
        <div class="btn-wrap">
          <button @click="onSubmit" type="submit">{{ mode === 'create' ? '생성' : '수정' }}</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mode: 'create',
      addressCreateInfoList: [{
        city: '',
        postCode: '00000',
        street: ''
      }],
      email: 'test@test.com',
      password: '',
      name: '',
      nickname: '',
      gender: 'MALE',
      birth: '1996-07-26',
      grade: 'BRONZE',
      snsLoginYn: false,
      role: 'USER',
      state: 'GENERAL'
    }
  },
  mounted() {
    console.log('환경변수 확인');
    console.log(process.env);
  },
  methods: {
    addAddressInfo() {
      if(this.addressCreateInfoList.length < 4) {
        this.addressCreateInfoList.push({
          city: '', // 현재 영문만 가능
          postCode: '00000',
          street: '' // 현재 영문만 가능
        });
      }
    },
    removeAddressInfo() {
      if(this.addressCreateInfoList.length > 1) {
        this.addressCreateInfoList.splice(this.addressCreateInfoList.length - 1, 1);
      }
    },
    async onSubmit() {
      console.log('제출')
      const params = {
        // addressCreateInfoList: this.addressCreateInfoList.map((v) => {return {...v, postCode: v.postCode.toString()}}),
        addressCreateInfoList: this.addressCreateInfoList,
        birth: this.birth,  // 1996-07-26 <-- 반드시 이 형식으로 입력
        email: this.email,
        gender: this.gender,
        grade: this.grade,
        // lastLoginedAt: "2022-09-27T10:47:02.673Z",   // <-- 스웨거에서는 왼쪽의 폼으로 보내짐
        lastLoginedAt: "",
        name: this.name,  // 영어 안됨..
        nickname: this.nickname,  // 영어 됨..뭐냐 진짜..
        profileImagePath: "string",
        password: this.password,
        role: this.role,  // 현재 CUSTOMER 안됨!
        snsLoginYn: this.snsLoginYn,
        state: this.state === 'BANNED' ? this.state : null,
        loginFailCount: 0,
        mobile: "M",
      };

      try {
        const res = await this.$axios.post(
          '/members',
          params,
          {
            headers: { "Content-Type": `application/json`}
          }
        );
  
        // let res = await this.$axios.get('/members');
        // console.log(res);
  
        console.log('결과')
        console.log(res)
      } catch(err) {
        console.log(err)
      }
    }
  }
}
</script>