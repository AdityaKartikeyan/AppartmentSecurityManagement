import React, { Component } from "react";
import DeliveryService from "../services/DeliveryService";

let today = new Date();
//const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-5]+$/);

const formValid = ({ isError, ...rest }) => {
  let valid = true;

  Object.values(isError).forEach((val) => {
    val.length > 0 && (valid = false);
  });

  Object.values(rest).forEach((val) => {
    val == null && (valid = false);
  });

  return valid;
};
class UpdateDeliveryComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      deliveryId: this.props.match.params.deliveryId,
      createdBy: "",
      modifiedBy: "",
      id: "",
      ownerName: "",
      time: "",
      status: "",
      isError: {
        createdBy: "",
        modifiedBy: "",
        deliveryId: "",
        ownerName: "",
        status: "",
        time: "",
      },
      disabled: true,
    };
    this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
    this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
    this.changeDeliveryIdHandler = this.changeDeliveryIdHandler.bind(this);
    this.changeOwnerNameHandler = this.changeOwnerNameHandler.bind(this);
    this.changeTimeHandler = this.changeTimeHandler.bind(this);
    this.changeStatusHandler = this.changeStatusHandler.bind(this);
    this.updateDelivery = this.updateDelivery.bind(this);
  }

  componentDidMount() {
    DeliveryService.getDeliveryByDeliveryId(this.state.deliveryId).then(
      (res) => {
        let delivery = res.data;
        this.setState({
          createdBy: delivery.createdBy,
          modifiedBy: delivery.modifiedBy,
          id: delivery.id,
          ownerName: delivery.ownerName,
          time: delivery.time,
          status: delivery.status,
        });
      }
    );
  }

  updateDelivery = (e) => {
    e.preventDefault();
    if (formValid(this.state)) {
      let delivery = {
        id: this.state.id,
        deliveryId: this.state.deliveryId,
        createdBy: this.state.createdBy,
        modifiedBy: this.state.modifiedBy,
        ownerName: this.state.ownerName,
        time: this.state.time,
        status: this.state.status,
        date: today,
      };
      console.log("delivery => " + JSON.stringify(delivery));
      DeliveryService.updateDelivery(delivery, this.state.deliveryId).then(
        (res) => {
          this.props.history.push("");
          // alert("form is valid");
        }
      );
    } else {
      alert("form is invalid");
    }
  };
  changeCreatedByHandler = (event) => {
    this.setState({ createdBy: event.target.value });
  };
  changeModifiedByHandler = (event) => {
    this.setState({ modifiedBy: event.target.value });
  };
  changeDeliveryIdHandler = (event) => {
    this.setState({ deliveryId: event.target.value });
  };
  changeOwnerNameHandler = (event) => {
    this.setState({ ownerName: event.target.value });
  };

  changeTimeHandler = (event) => {
    this.setState({ time: event.target.value });
  };

  changeStatusHandler = (event) => {
    this.setState({ status: event.target.value });
  };
  changeDateHandler = (event) => {
    this.setState({ today: event.target.value });
  };

  cancel() {
    this.props.history.push("");
  }
  formValChange = (e) => {
    e.preventDefault();

    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
      case "createdBy":
        isError.createdBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "modifiedBy":
        isError.modifiedBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "deliveryId":
        isError.deliveryId = regExp2.test(value)
          ? ""
          : "Numeric Values Required";
        break;
      case "ownerName":
        isError.ownerName =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "status":
        isError.status =
          value.length < 4 ? "Atleast 4 characters required" : "";
        break;
      case "time":
        break;
      default:
        break;
    }
    this.setState(
      {
        isError,
        [name]: value,
        disabled: false,
      },
      () => console.log(this.state)
    );
  };
  render() {
    const { isError } = this.state;
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Update Delivery</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Created By</label>
                    <input
                      placeholder="createdBy"
                      name="createdBy"
                      className={
                        isError.createdBy.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.createdBy}
                      noValidate
                      onChange={
                        (this.changeCreatedByHandler, this.formValChange)
                      }
                    />
                    {isError.createdBy.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.createdBy}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Modified By</label>
                    <input
                      placeholder="Modified By"
                      name="modifiedBy"
                      className={
                        isError.modifiedBy.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.modifiedBy}
                      noValidate
                      onChange={
                        (this.changeModifiedByHandler, this.formValChange)
                      }
                    />
                    {isError.modifiedBy.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.modifiedBy}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label> Delivery Id: </label>
                    <input
                      placeholder="Delivery Id"
                      name="deliveryId"
                      className={
                        isError.deliveryId.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.deliveryId}
                      onChange={
                        (this.changeDeliveryIdHandler, this.formValChange)
                      }
                    />
                    {isError.deliveryId.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.deliveryId}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label> Owner Name: </label>
                    <input
                      placeholder="Owner Name"
                      name="ownerName"
                      className={
                        isError.ownerName.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.ownerName}
                      onChange={
                        (this.changeOwnerNameHandler, this.formValChange)
                      }
                    />
                    {isError.ownerName.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.ownerName}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Time </label>
                    <br></br>
                    <select
                      className="form-control"
                      name="time"
                      id="time"
                      value={this.state.time}
                      noValidate
                      onChange={(this.changeTimeHandler, this.formValChange)}
                    >
                      <option defaultValue="select">Select</option>
                      <option value="09:00">09:00 am</option>
                      <option value="09:30">09:30 am</option>
                      <option value="10:00">10:00 am</option>
                      <option value="10:30">10:30 am</option>
                      <option value="11:00">11:00 am</option>
                      <option value="11:30">11:30 am</option>
                      <option value="12:00">12:00 pm</option>
                      <option value="12:30">12:30 pm</option>
                      <option value="01:00">01:00 pm</option>
                      <option value="01:30">01:30 pm</option>
                      <option value="02:00">02:00 pm</option>
                      <option value="02:30">02:30 pm</option>
                      <option value="03:00">03:00 pm</option>
                      <option value="03:30">03:30 pm</option>
                      <option value="04:00">04:00 pm</option>
                      <option value="04:30">04:30 pm</option>
                      <option value="05:00">05:00 pm</option>
                      <option value="05:30">05:30 pm</option>
                      <option value="06:00">06:00 pm</option>
                      <option value="06:30">06:30 pm</option>
                    </select>
                  </div>

                  <div className="form-group">
                    <label> Status: </label>
                    <input
                      placeholder="Status"
                      name="status"
                      className={
                        isError.status.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.status}
                      onChange={(this.changeStatusHandler, this.formValChange)}
                    />
                    {isError.status.length > 0 && (
                      <span className="invalid-feedback">{isError.status}</span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Date:</label>
                    <input
                      placeholder="Date"
                      name="date"
                      className="form-control"
                      value={today}
                      onChange={this.changeDateHandler}
                    />
                  </div>

                  <button
                    disabled={this.state.disabled}
                    className="btn btn-success"
                    onClick={this.updateDelivery}
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UpdateDeliveryComponent;
