import React, { Component } from 'react'
import DeliveryService from '../services/DeliveryService';

let today = new Date();

class UpdateDeliveryComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            deliveryId: this.props.match.params.deliveryId,
            id: '',
            ownerName: '',
            time: '',
            status: ''
        }
        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeOwnerNameHandler = this.changeOwnerNameHandler.bind(this);
        this.changeTimeHandler = this.changeTimeHandler.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
        this.updateDelivery = this.updateDelivery.bind(this);
    }

    componentDidMount() {
        DeliveryService.getDeliveryByDeliveryId(this.state.deliveryId).then((res) => {
            let delivery = res.data;
            this.setState({
                id: delivery.id, ownerName: delivery.ownerName, time: delivery.time, status: delivery.status
            });
        });
    }

    updateDelivery = (e) => {
        e.preventDefault();
        let delivery = { id: this.state.id, ownerName: this.state.ownerName, time: this.state.time, status: this.state.status, date: today };
        console.log('delivery => ' + JSON.stringify(delivery));
        DeliveryService.updateDelivery(delivery, this.state.deliveryId).then(res => {
            this.props.history.push('');
        });
    }
    changeIdHandler = (event) => {
        this.setState({ id: event.target.value });
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
                            <h3 className="text-center">Update Delivery</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Id: </label>
                                        <input placeholder="Id" name="Id" className="form-control"
                                            value={this.state.id} onChange={this.changeIdHandler} />
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

                                    <button className="btn btn-success" onClick={this.updateDelivery}>Save</button>
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

export default UpdateDeliveryComponent
