import React, { Component } from "react";
import VisitorService from "../services/VisitorService";

let today = new Date();

const regExp1 = RegExp(/^[0-9]+$/);
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

class UpdateVisitorComponent extends Component {
  constructor(props) {
    super(props);
  
      this.state = {
        createdBy: "",
        modifiedBy: "",
        visitorId: this.props.match.params.visitorId,
        id: "",
        name: "",
        ownerName: "",
        flatNo: "",
        arrivalTime: "",
        departureTime: "",
        isError: {
          createdBy: "",
          modifiedBy: "",
          visitorId: "",
          name: "",
          ownerName: '',
          flatNo: "",
          arrivalTime: "",
          departureTime: ""
        },
        disabled: true,
      };
      
      this.changeIdHandler  = this.changeIdHandler.bind(this);
      this.changeVisitorIdHandler  = this.changeVisitorIdHandler.bind(this);
      this.changeVisitorNameHandler = this.changeVisitorNameHandler.bind(this);
      this.changeOwnerNameHandler = this.changeOwnerNameHandler.bind(this);
      this.changeFlatNoHandler = this.changeFlatNoHandler.bind(this);
      this.changeDateHandler = this.changeDateHandler.bind(this);
      this.changeArrivalTimeHandler = this.changeArrivalTimeHandler.bind(this);
      this.changeDepartureTimeHandler = this.changeDepartureTimeHandler.bind(this);
      this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
      this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);

      this.updateVisitor = this.updateVisitor.bind(this);
    }
  
    componentDidMount() {
      VisitorService.getVisitorByUserId(this.state.visitorId).then(
        (res) => {
          let visitors = res.data;
          this.setState({
            createdBy: visitors.createdBy,
            modifiedBy: visitors.modifiedBy,
            id: visitors.id,
            visitorId: visitors.visitorId,
            name: visitors.name,
            ownerName: visitors.ownerName,
            flatNo: visitors.flatNo,
            arrivalTime: visitors.arrivalTime,
            departureTime: visitors.departureTime
          });
        }
      );
    }

    updateVisitor = (e) => {
      e.preventDefault();
      if(formValid(this.state)){
      let visitors = {
        createdBy: this.state.createdBy,
        modifiedBy: this.state.modifiedBy,
        id: this.state.id,
        visitorId: this.state.visitorId,
        name: this.state.name,
        ownerName: this.state.ownerName,
        flatNo: this.state.flatNo,
        date: today,
        arrivalTime: this.state.arrivalTime,
        departureTime: this.state.departureTime
      };
      console.log("visitors => " + JSON.stringify(visitors));
      VisitorService.updateVisitor(visitors, this.state.visitorId).then((res) => {
        this.props.history.push("");
        alert("Form is updated successfully!")
        }
      );}
      else{
        alert("Form is invalid...")
      }
    };

    changeCreatedByHandler = (event) => {
      this.setState({ createdBy: event.target.value });
    };

    changeModifiedByHandler = (event) => {
      this.setState({ modifiedBy: event.target.value });
    };

    changeIdHandler = (event) => {
        this.setState({id: event.target.value});
    }

    changeVisitorIdHandler = (event) => {
      this.setState({visitorId: event.target.value});
    }

    changeVisitorNameHandler = (event) => {
        this.setState({name: event.target.value});
    }

    changeOwnerNameHandler = (event) => {
        this.setState({ownerName: event.target.value});
    }

    changeFlatNoHandler = (event) => {
        this.setState({flatNo: event.target.value});
    }

    changeDateHandler = (event) => {
        this.setState({today: event.target.value });
    }

    changeArrivalTimeHandler = (event) => {
        this.setState({arrivalTime: event.target.value});
    }

    changeDepartureTimeHandler = (event) => {
        this.setState({departureTime: event.target.value});
    }

    cancel() {
      this.props.history.push("");
    }

    formValChange = (e) => {
      e.preventDefault();
      const { name, value } = e.target;
      let isError = { ...this.state.isError };
      switch (name) {
          case "userId":
              isError.visitorId = regExp2.test(value) ? "" : "Numeric Value Required for Visitor ID";
              break;
          case "name":
              isError.name = value.length < 3 ? "Atleast 3 characters required for Visitor's name" : "";
              break;
          case "ownerName":
              isError.ownerName = value.length < 3 ? "Atleast 3 characters required for Owner's name" : "";
              break;
          case "flatNo":
              isError.flatNo = regExp1.test(value) ? "" : "Flat Number is Invalid";
              break; 
          case "departureTime":
              break;
          case "arrivalTime":
              break; 
          case "createdBy":
                isError.createdBy =
                  value.length < 5 ? "Atleast 5 characters required" : "";
              break;
          case "modifiedBy":
                isError.modifiedBy =
                  value.length < 5 ? "Atleast 5 characters required" : "";
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
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Update Visitor's Details</h3>
              <div className="card-body">
                <form>
                <div className="form-group">
                  <label>Modified By</label>
                  <input
                    placeholder="modifiedBy"
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

                <div className = "form-group">
                    <label> ID: </label>
                    <input placeholder="ID" name="id" 
                    className="form-control" 
                      value={this.state.id} onChange={this.changeIdHandler}/>
                  </div>
                  <div className = "form-group">
                    <label> Visitor ID: </label>
                    <input placeholder="Visitor ID" name="visitorId" 
                    className={ isError.visitorId.length > 0 
                      ? "is-invalid form-control"
                      : "form-control"}
                      value={this.state.visitorId} 
                      onChange={(this.changeVisitorIdHandler,this.formValChange)}/>
                        {isError.visitorId.length > 0 && (
                        <span className="invalid-feedback">
                            {isError.visitorId}
                        </span>
                        )}
                  </div>
                  <div className = "form-group">
                    <label> Visitor Name: </label>
                    <input placeholder="Visitor Name" name="name" 
                    className={ isError.name.length > 0 
                      ? "is-invalid form-control"
                      : "form-control"} 
                      value={this.state.name} 
                      onChange={(this.changeVisitorNameHandler,this.formValChange)}/>
                        {isError.visitorId.length > 0 && (
                        <span className="invalid-feedback">
                            {isError.name}
                        </span>
                        )}
                  </div>
                  <div className = "form-group">
                    <label> Owner Name: </label>
                    <input placeholder="Owner Name" name="ownerName" 
                    className={ isError.ownerName.length > 0 
                      ? "is-invalid form-control"
                      : "form-control"}
                      value={this.state.ownerName} 
                      onChange={(this.changeOwnerNameHandler,this.formValChange)}/>
                        {isError.visitorId.length > 0 && (
                        <span className="invalid-feedback">
                            {isError.ownerName}
                        </span>
                        )}
                  </div>
                  <div className = "form-group">
                    <label> Flat Number: </label>
                    <input placeholder="Flat Number" name="flatNo" 
                    className={ isError.flatNo.length > 0 
                      ? "is-invalid form-control"
                      : "form-control"} 
                      value={this.state.flatNo} 
                      onChange={(this.changeFlatNoHandler,this.formValChange)}/>
                        {isError.visitorId.length > 0 && (
                        <span className="invalid-feedback">
                            {isError.flatNo}
                        </span>
                        )}
                  </div>
                  <div className = "form-group">
                    <label> Date: </label>
                    <input placeholder="Date" name="date" className="form-control" 
                      value={today} onChange={this.changeDateHandler}/>
                  </div>
                  <div className="form-group">
                    <label>Arrival Time:</label>
                    <br></br>
                      <select
                        className="form-control" name="arrivalTime" id="arrivalTime"
                        value={this.state.arrivalTime} noValidate
                        onChange={(this.changeArrivalTimeHandler,this.formValChange)}
                      >
                      <option value="0730">7.30 am</option>
                      <option value="0830">8.30 am</option>
                      <option value="0930">9.30 am</option>
                      <option value="1030">10.30 am</option>
                      <option value="1130">11.30 am</option>
                      <option value="1230">12.30 pm</option>
                      <option value="1330">1.30 pm</option>
                      <option value="1430">2.30 pm</option>
                      <option value="1530">3.30 pm</option>
                      <option value="1630">4.30 pm</option>
                      <option value="1730">5.30 pm</option>
                      <option value="1830">6.30 pm</option>
                      <option value="1930">7.30 pm</option>
                      <option value="2030">8.30 pm</option>
                      <option value="2130">9.30 pm</option>
                      <option value="2230">10.30 pm</option>
                      <option value="2330">11.30 pm</option>
                      </select>
                  </div>
                  <div className="form-group">
                    <label>Departure Time:</label>
                    <br></br>
                      <select
                        className="form-control" name="departureTime:" id="departureTime"
                        value={this.state.departureTime} noValidate
                        onChange={this.changeDepartureTimeHandler}
                      >
                      <option value="0800">8.00 am</option>
                      <option value="0900">9.00 am</option>
                      <option value="1000">10.00 am</option>
                      <option value="1100">11.00 am</option>
                      <option value="1200">12.00 pm</option>
                      <option value="1300">1.00 pm</option>
                      <option value="1400">2.00 pm</option>
                      <option value="1500">3.00 pm</option>
                      <option value="1600">4.00 pm</option>
                      <option value="1700">5.00 pm</option>
                      <option value="1800">6.00 pm</option>
                      <option value="1900">7.00 pm</option>
                      <option value="2000">8.00 pm</option>
                      <option value="2100">9.00 pm</option>
                      <option value="2200">10.00 pm</option>
                      <option value="2300">11.00 pm</option>
                      <option value="0000">12.00 pm</option>
                      </select>
                  </div>

                  <button disabled={this.state.disabled} className="btn btn-success" 
                    onClick={this.updateVisitor}>Save</button>
                  <button className="btn btn-danger" onClick={this.cancel.bind(this)} 
                    style={{marginLeft: "10px"}}>Cancel</button> 

                </form>
              </div>
            </div>
          </div>
        </div>
      );
    }
  }
  
  export default UpdateVisitorComponent;