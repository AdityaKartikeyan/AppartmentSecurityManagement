import React, { Component } from "react";
import VehicleService from "../services/VehicleService";

class ViewVehicleComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      vehicleNo: this.props.match.params.vehicleNo,
      vehicle: {},
    };
  }

  componentDidMount() {
    VehicleService.getVehiclesByVehicleNo(this.state.vehicleNo).then(
      (res) => {
        this.setState({ vehicle: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Vehicle Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Vehicle Name: </label>
              <div> {this.state.vehicle.name}</div>
            </div>
            <div className="row">
              <label> Vehicle Parking Number: </label>
              <div> {this.state.vehicle.parkingNo}</div>
            </div>
            <div className="row">
              <label> Vehicle Arrival Time: </label>
              <div> {this.state.vehicle.arrivalTime}</div>
            </div>
            <div className="row">
              <label> Vehicle Departure Time: </label>
              <div> {this.state.vehicle.departureTime}</div>
            </div>
            <div className="row">
              <label> Vehicle Number: </label>
              <div> {this.state.vehicle.vehicleNo}</div>
            </div>
            <div className="row">
              <label> Date: </label>
              <div> {this.state.vehicle.date}</div>
            </div>
            <div className="row">
              <label> Vehicle Type: </label>
              <div> {this.state.vehicle.vehicleType}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ViewVehicleComponent;