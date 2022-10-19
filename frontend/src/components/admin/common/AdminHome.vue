<template>
  <div class="admin-home-container">
    <h2>어드민 홈 화면 입니다</h2>
  </div>
</template>

<script>
export default {
  mounted() {
    console.log('환경변수 테스트')
    console.log('NODE_ENV: '+ process.env.NODE_ENV)
    console.log('VUE_APP_API_URL: '+ process.env.VUE_APP_API_URL)
  }
}
</script>