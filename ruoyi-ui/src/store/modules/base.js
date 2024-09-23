
const state = {
  isMobile: false,
}

const mutations = {
  UPDATE_ISMOBILE(state, data) {
    state.isMobile = data;
  },
}

const actions = {
  updateIsMobile({ commit }, data) {
    commit('UPDATE_ISMOBILE', data);
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
