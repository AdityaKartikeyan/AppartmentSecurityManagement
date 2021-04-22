import axios from 'axios';

const GUARDSALARY_API_BASE_URL = "http://localhost:7070/guard/";

class GuardSalaryService{

    getGuardSalay(){
        return axios.get(GUARDSALARY_API_BASE_URL+"getAll");
    }
    createGuardSalary(guardSalary){
        return axios.post(GUARDSALARY_API_BASE_URL + "addGuard", guardSalary);
    }

    getGuardSalayById(userId){
        return axios.get(GUARDSALARY_API_BASE_URL + "getById/"+ userId);
    }
    updateGuardSalary(guardSalary, userId) {
        return axios.put(GUARDSALARY_API_BASE_URL + "updateGuard/" + userId, guardSalary);
      }
    deleteGuardSalary(id) {
     return axios.delete(GUARDSALARY_API_BASE_URL + "deleteGuard/" + id);
      }
}
export default new GuardSalaryService()

