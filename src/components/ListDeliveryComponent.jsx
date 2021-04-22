import React, { Component } from "react";
import DeliveryService from "../services/DeliveryService";

class ListDeliveryComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      delivery: []
    };
    this.addDelivery = this.addDelivery.bind(this);
    this.editDelivery = this.editDelivery.bind(this);
    this.deleteDelivery = this.deleteDelivery.bind(this);
  }
  componentDidMount() {
    DeliveryService.getDelivery().then((res) => {
      this.setState({ delivery: res.data });
    });
  }
  addDelivery() {
    this.props.history.push('/addDelivery');
  }
  editDelivery(deliveryId) {
    this.props.history.push(`/updateDelivery/${deliveryId}`);
  }
  viewDelivery(deliveryId) {
    this.props.history.push(`/getByPk/${deliveryId}`);
  }
  deleteDelivery(id) {
    DeliveryService.deleteDelivery(id).then(res => {
      this.setState({ delivery: this.state.delivery.filter(delivery => delivery.id !== id) });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center">DeliveryList</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.addDelivery}>
            Add Delivery
          </button>
        </div>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Delivery Id</th>
                <th>Onwer Name</th>
                <th>Time</th>
                <th>Status</th>
                <th>Date</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.delivery.map((delivery) => (
                <tr key={delivery.deliveryId}>
                  <td>{delivery.deliveryId}</td>
                  <td>{delivery.ownerName}</td>
                  <td>{delivery.time}</td>
                  <td>{delivery.status}</td>
                  <td>{delivery.date}</td>
                  <td><button onClick={() => this.editDelivery(delivery.deliveryId)} className="btn btn-info">Update</button>
                    <button style={{ marginLeft: "10px" }} onClick={() => this.deleteDelivery(delivery.id)} className="btn btn-danger">Delete</button>
                    <button style={{ marginLeft: "10px" }} onClick={() => this.viewDelivery(delivery.deliveryId)} className="btn btn-info">View</button></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListDeliveryComponent;
