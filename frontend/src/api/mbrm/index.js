import axios from "axios"

/**
 * 로그인
 */
export const login = () => {
  axios.post()
}

/**
 * 모든회원 조회
 */
export const getMembers = () => {
  axios.post.get('/members')
}

/**
 * 회원가입 요청
 */
export const memberEntry = (params) => {
  axios.post.post('/members', params, {
    headers: { "Content-Type": `application/json`}
  })
}
