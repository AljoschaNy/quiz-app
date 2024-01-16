import "./OptionCard.css";
import {OptionCardProps} from "../../types/types.ts";

function OptionCard({ topic }:Readonly<OptionCardProps>) {

    return (
        <button className={"option-card"}>
            <img className={topic.name.toLowerCase() + "-img topic-img"} src={topic.path} alt={topic.name + " illustration"} />
            <span className={"option-text"}>{topic.name}</span>
        </button>
    );
}

export default OptionCard;
