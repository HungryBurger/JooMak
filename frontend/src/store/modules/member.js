export const SET_ADDRESS_DETAIL = "SET_ADDRESS_DETAIL";
export const SET_CHANGE_MODE = "SET_CHANGE_MODE";
export const SET_ADDRESS_SELECTED = "SET_ADDRESS_SELECTED";
export const SIGN_UP = "SIGN_UP";

export const member = {
  namespaced: true,
  state: () => ({
    addressList: [
      {
        idx: 1,
        selected: false,
        name: "우리집",
        addressMain: "서울특별시 강남구 논현동 123-45",
        addressDetail: "3동 1101호",
        changeMode: false,
      },
      {
        idx: 2,
        selected: false,
        name: "할머니 댁",
        addressMain: "경기도 화성시 봉담읍 456-12",
        addressDetail: "105동 115호",
        changeMode: false,
      },
      {
        idx: 3,
        selected: false,
        name: "사무실",
        addressMain: "서울특별시 송파구 잠실동 765-43",
        addressDetail: "L타워 4602호",
        changeMode: false,
      },
      {
        idx: 4,
        selected: true,
        name: "이모 댁",
        addressMain: "인천광역시 부평구 부평동 332-12",
        addressDetail: "A아파트 303호",
        changeMode: false,
      },
    ],
  }),
  getters: {
    currentAddressObj(state) {
      let currentAddressObj = {};
      for (let i = 0; i < state.addressList.length; i++) {
        if (state.addressList[i].selected === true) {
          currentAddressObj = state.addressList[i];
          return currentAddressObj;
        }
      }
      return null;
    },
  },
  mutations: {
    [SET_ADDRESS_DETAIL](state, { index, inputText }) {
      state.addressList[index].addressDetail = inputText;
    },
    [SET_CHANGE_MODE](state, { index, boolean }) {
      state.addressList[index].changeMode = boolean;
    },
    [SET_ADDRESS_SELECTED](state, { index, boolean }) {
      state.addressList[index].selected = boolean;
    },
  },
  actions: {
    [SET_CHANGE_MODE]({ commit }, { indexToCancel, indexToEdit }) {
      if (indexToCancel !== -1) {
        commit(SET_CHANGE_MODE, {
          index: indexToCancel,
          boolean: false,
        });
      }
      commit(SET_CHANGE_MODE, { index: indexToEdit, boolean: true });
    },
    [SET_ADDRESS_SELECTED]({ state, commit }, idx) {
      /* 1. Back 처리 ( * Axios 통신 로직 삽입 예정 ) */

      /* 2. Front 처리 */
      //   1) 기존 selected 취소
      const addressList = state.addressList;
      for (let i = 0; i < addressList.length; i++) {
        if (addressList[i].selected === true) {
          commit(`${SET_ADDRESS_SELECTED}`, {
            index: i,
            boolean: false,
          });
          break;
        }
      }

      //   2) 선택된 주소 selected 적용
      for (let i = 0; i < addressList.length; i++) {
        if (addressList[i].idx === idx) {
          commit(`${SET_ADDRESS_SELECTED}`, { index: i, boolean: true });
          break;
        }
      }
    },
    [SIGN_UP]({ commit }, authData) {
      axios
        .post("/signupNewUser?key=AAAAAAAAAAAAAAAAAA-ccccccccccccccccccc", {
          username: authData.username,
          // email: authData.email,
          password: authData.password,
          returnSecureToken: true,
        })
        .then((res) => console.log(res))
        .catch((error) => console.log(error));
    },
  },
};
