import React, { Component } from "react";
import DeliveryService from "../services/DeliveryService";

let today = new Date();

class CreateDeliveryComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            deliveryId: '',
            ownerName: '',
            time: '',
            status: '',
            date: ''
        }
        this.changeDeliveryIdHandler = this.changeDeliveryIdHandler.bind(this);
        this.changeOwnerNameHandler = this.changeOwnerNameHandler.bind(this);
        this.changeTimeHandler = this.changeTimeHandler.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
        this.changeDateHandler = this.changeDateHandler.bind(this);
        this.saveDelivery = this.saveDelivery.bind(this);
    }
    saveDelivery = (e) => {
        e.preventDefault();
        let delivery = { deliveryId: this.state.deliveryId, ownerName: this.state.ownerName, time: this.state.time, status: this.state.status, date: today };
        console.log('delivery => ' + JSON.stringify(delivery));
        DeliveryService.createDelivery(delivery).then(res => {
            this.props.history.push('');
        });
    }
    changeDeliveryIdHandler = (event) => {
        this.setState({ deliveryId: event.target.value });
    }
    changeOwnerNameHandler = (event) => {
        this.setState({ ownerName: event.target.value });
    }

    changeTimeHandler = (event) => {
        this.setState({ time: event.target.value });
    }

    changeStatusHandler = (event) => {
        this.setState({ status: event.target.value });
    }
    changeDateHandler = (event) => {
        this.setState({ today: event.target.value });
    }

    cancel() {
        this.props.history.push('');
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="container" >
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Delivery</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Delivery Id: </label>
                                        <input placeholder="Delivery Id" name="deliveryId" className="form-control"
                                            value={this.state.deliveryId} onChange={this.changeDeliveryIdHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Owner Name: </label>
                                        <input placeholder="Owner Name" name="ownerName" className="form-control"
                                            value={this.state.ownerName} onChange={this.changeOwnerNameHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Time: </label>
                                        <input placeholder="Time" name="time" className="form-control"
                                            value={this.state.time} onChange={this.changeTimeHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Status: </label>
                                        <input placeholder="Status" name="status" className="form-control"
                                            value={this.state.status} onChange={this.changeStatusHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>Date:</label>
                                        <input placeholder="Date" name="date" className="form-control"
                                            value={today} onChange={this.changeDateHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.saveDelivery}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}
export default CreateDeliveryComponent;
