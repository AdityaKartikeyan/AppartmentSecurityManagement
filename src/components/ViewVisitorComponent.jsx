import React, { Component } from "react";
import VisitorService from "../services/VisitorService";

class ViewVisitorComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      visitorId: this.props.match.params.visitorId,
      visitors: {},
    };
  }

  componentDidMount() {
    VisitorService.getVisitorByUserId(this.state.visitorId).then((res) => {
        this.setState({ visitors: res.data });
      }
    );
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Visitors' Detail</h3>
          <div className="card-body">
            <div className="row">
              <label> Visitor ID: </label>
              <div> {this.state.visitors.visitorId}</div>
            </div>
            <div className="row">
              <label> Visitor Name: </label>
              <div> {this.state.visitors.name}</div>
            </div>
            <div className="row">
              <label> Owner Name: </label>
              <div> {this.state.visitors.ownerName}</div>
            </div>
            <div className="row">
              <label> Flat Number: </label>
              <div> {this.state.visitors.flatNo}</div>
            </div>
            <div className="row">
              <label> Date: </label>
            <div> {this.state.visitors.date}</div>
            </div>
            <div className="row">
              <label> Arrival Time: </label>
            <div> {this.state.visitors.arrivalTime}</div>
            </div>
            <div className="row">
              <label> Departure Time: </label>
            <div> {this.state.visitors.departureTime}</div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ViewVisitorComponent;