<template>
  <div class="member-read-container">
    <div class="member-read-wrap">
      <div class="top">
        <h6>Member Read</h6>
      </div>
      <div class="bottom">
        <table>
          <colgroup>
            <col width="*">
            <col width="30%">
            <col width="*">
            <col width="*">
            <col width="*">
            <col width="*">
            <col width="*">
            <col width="*">
          </colgroup>
          <thead>
            <tr>
              <th>Idx</th>
              <th>E-Mail</th>
              <th>PW</th>
              <th>이름</th>
              <th>Nick</th>
              <th>성별</th>
              <th>생일</th>
              <th>등급</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(person, idx) in res" :key="idx">
              <td>{{ person.id }}</td>
              <td>{{ person.email }}</td>
              <td>{{ person.password }}</td>
              <td>{{ person.memberName }}</td>
              <td>{{ person.nickName }}</td>
              <td>{{ person.gender }}</td>
              <td>{{ person.birth }}</td>
              <td>{{ person.grade }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      res: []
    }
  },
  async created() {
    try {
      const res = await this.$axios.get('/members');
      console.log('MemberRead 회원 호출 결과')
      console.log(res);
      let newRes = [].concat(res.data);  // 깊은 복사
      this.res = newRes.splice(13, 10);
      console.log('임시 표시용 newRes')
      console.log(this.res)
    } catch(err) {
      console.error(err)
    }
  }
}
</script>