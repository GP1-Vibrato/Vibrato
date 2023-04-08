import React, { useState } from "react";
import "../Styles/dropdown.css";

const Dropdown = ({ options, onSelect }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedOption, setSelectedOption] = useState(options[0]);

  const handleOptionSelect = (option) => {
    setSelectedOption(option);
    onSelect(option.value);
    setIsOpen(false);
  };

  const handleDropdownClick = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="dropdown-container">
      <div className={`dropdown ${isOpen ? "open" : ""}`} onClick={handleDropdownClick}>
        <div className="dropdown-selected">{selectedOption.label}</div>
        <div className="dropdown-icon">&#9662;</div>
      </div>
      {isOpen && (
        <div className="dropdown-options">
          {options.map((option) => (
            <div className="ops" key={option.value} onClick={() => handleOptionSelect(option)}>
              {option.label}
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Dropdown;
