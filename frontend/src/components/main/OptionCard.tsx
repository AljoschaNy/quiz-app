import "./OptionCard.css";
import {OptionCardProps} from "../../types/types.ts";

function OptionCard({ topic }:Readonly<OptionCardProps>) {

    return (
        <button className={"option-card"}>
            <img className={topic.title.toLowerCase() + "-img topic-img"} src={topic.icon} alt={topic.title + " illustration"} />
            <span className={"option-text"}>{topic.title}</span>
        </button>
    );
}

export default OptionCard;
