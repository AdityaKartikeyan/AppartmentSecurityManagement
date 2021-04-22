import axios from "axios";

const GUARD_API_BASE_URL = "http://localhost:9090/guard/";
class GuardTrainingService {
  getGuardTraining() {
    return axios.get(GUARD_API_BASE_URL + "getAll");
  }

  createGuardTraining(guards) {
    return axios.post(GUARD_API_BASE_URL + "addGuard", guards);
  }

  getGuardTrainingByUserId(userId) {
    return axios.get(GUARD_API_BASE_URL + "getById/" + userId);
  }

  updateGuardTraining(guards, userId) {
    return axios.put(GUARD_API_BASE_URL + "updateGuard/" + userId, guards);
  }

  deleteGuardTraining(id) {
    return axios.delete(GUARD_API_BASE_URL + "deleteGuard/" + id);
  }
}

export default new GuardTrainingService();
