import React, { Component } from "react";
import VisitorService from "../services/VisitorService";

class BaseEntity extends Component {
  constructor(props) {
    super(props);

    this.state = {
      visitorId: this.props.match.params.visitorId,
      base: {},
    };
  }

  componentDidMount() {
    VisitorService.getVisitorByUserId(this.state.visitorId).then(
      (res) => {
        this.setState({ base: res.data });
      }
    );
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center"> View Auditing Details</h3>
          <div className="card-body">
            <div className="row">
              <label> Id: </label>
              <div> {this.state.base.id}</div>
            </div>
            <div className="row">
              <label> Created By: </label>
              <div> {this.state.base.createdBy}</div>
            </div>
            <div className="row">
              <label> Modified By: </label>
              <div> {this.state.base.modifiedBy}</div>
            </div>

            <div className="row">
              <label> Created DateTime: </label>
              <div> {this.state.base.createdDateTime}</div>
            </div>

            <div className="row">
              <label> Modified DateTime: </label>
              <div> {this.state.base.modifiedDateTime}</div>
            </div>

          </div>
        </div>
      </div>
    );
  }
}

export default BaseEntity;