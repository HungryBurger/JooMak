<template>
  <div class="member-create-container">
    <div class="member-create-wrap">
      <h6>회원 Mockup {{ mode === 'create' ? 'Create' : 'Update' }}</h6>
      <form @submit.prevent="onSubmit">
        <ul>
          <li>
            <div>
              <label for="idxInit">Idx (id) 초기값</label>
              <input type="text" name="idxInit" v-model="idx">
            </div>
          </li>
          <li>
            <div>
              <label for="idx">Idx (id)</label>
              <input type="text" name="idx" readonly :value="idx">
            </div>
          </li>
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
              <label for="name">이름 (memberName)</label>
              <input type="text" name="name" v-model="memberName" placeholder="김철수">
            </div>
          </li>
          <li>
            <div>
              <label for="nickName">닉네임 (nickName)</label>
              <input type="text" name="nickName" v-model="nickName" placeholder="lovely철수">
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
            <div>
              <label for="birth">생일 (birth)</label>
              <input type="text" name="birth" v-model="birth" placeholder="19970101">
            </div>
          </li>
          <li>
            <div>
              <label for="grade">등급 (grade)</label>
              <input type="text" name="grade" v-model="grade" placeholder="GOLD">
            </div>
          </li>
        </ul>
        <div class="btn-wrap">
          <button type="submit">{{ mode === 'create' ? '생성' : '수정' }}</button>
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
      idx: 0,
      email: 'test@test.com',
      password: '',
      memberName: '',
      nickName: '',
      gender: 'MALE',
      birth: '19960726',
      grade: 'BRONZE'
    }
  },
  methods: {
    async onSubmit() {
      console.log('제출')
      const params = {
        id: this.idx,
        email: this.email,
        password: this.password,
        memberName: this.memberName,
        nickName: this.nickName,
        gender: this.gender,
        birth: this.birth,
        grade: this.grade
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