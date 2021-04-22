import axios from 'axios';

const DELIVERY_API_BASE_URL = "http://localhost:5050/delivery/";

class DeliveryService {
    getDelivery() {
        return axios.get(DELIVERY_API_BASE_URL + 'getAll');
    }
    createDelivery(delivery) {
        return axios.post(DELIVERY_API_BASE_URL + 'addDelivery', delivery);
    }
    updateDelivery(delivery, deliveryId) {
        return axios.put(DELIVERY_API_BASE_URL + 'updateDelivery/' + deliveryId, delivery);
    }
    getDeliveryByDeliveryId(deliveryId) {
        return axios.get(DELIVERY_API_BASE_URL + 'getByPk/' + deliveryId);
    }
    deleteDelivery(id) {
        return axios.delete(DELIVERY_API_BASE_URL + 'deleteDelivery/' + id);
    }
}

export default new DeliveryService()