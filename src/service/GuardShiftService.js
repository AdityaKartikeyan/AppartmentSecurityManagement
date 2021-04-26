import axios from 'axios';

const GUARDSHIFT_API_BASE_URL = "http://localhost:9090/guard/";

class GuardShiftService {

    getGuardShift(){
        return axios.get(GUARDSHIFT_API_BASE_URL + "getAll");
    }
    createGuardShift(guardShift) {
        return axios.post(GUARDSHIFT_API_BASE_URL + 'addGuard', guardShift);
     }
      getGuardShiftByUserId(userId) {
            return axios.get(GUARDSHIFT_API_BASE_URL + "getById/" + userId);
          }
        
          updateGuardShift(guardShift, userId) {
            return axios.put(GUARDSHIFT_API_BASE_URL + "updateGuard/" + userId, guardShift);
          }
        
          deleteGuardShift(id) {
            return axios.delete(GUARDSHIFT_API_BASE_URL + "deleteGuard/" + id);
          }
        }
    



export default new GuardShiftService()

