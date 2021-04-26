import axios from 'axios';

const VISITORS_API_BASE_URL = "http://localhost:1111/";

class VisitorService {

    getAllVisitors(){
        return axios.get(VISITORS_API_BASE_URL + "getAll");
    }

    createVisitor(visitors) {
        return axios.post(VISITORS_API_BASE_URL + "addVisitor", visitors);
    }
    
    getVisitorByUserId(visitorId) {
        return axios.get(VISITORS_API_BASE_URL + "getById/" + visitorId);
    }
    
    updateVisitor(visitors, visitorId) {
        return axios.put(VISITORS_API_BASE_URL + 'updateVisitor/' + visitorId, visitors);
    }
    
    deleteVisitor(id) {
        return axios.delete(VISITORS_API_BASE_URL + "deleteVisitor/" + id);
    }
}

export default new VisitorService()