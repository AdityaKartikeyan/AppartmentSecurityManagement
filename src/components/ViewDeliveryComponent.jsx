import React, { Component } from 'react';
import DeliveryService from "../services/DeliveryService";

class ViewDeliveryComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            deliveryId: this.props.match.params.deliveryId,
            delivery: {}
        }
    }
    
    componentDidMount(){
        DeliveryService.getDeliveryByDeliveryId(this.state.deliveryId).then(res=>{
            this.setState({delivery: res.data});
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Delivery Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Delivery Owner Name: </label>
                            <div> {this.state.delivery.ownerName }</div>
                        </div>
                        <div className = "row">
                            <label> Delivery Time: </label>
                            <div> { this.state.delivery.time }</div>
                        </div>
                        <div className = "row">
                            <label> Delivery Status: </label>
                            <div> { this.state.delivery.status }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewDeliveryComponent;