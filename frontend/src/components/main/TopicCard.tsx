import "./OptionCard.css";
import {OptionCardProps} from "../../types/types.ts";
import {useNavigate} from "react-router-dom";

function TopicCard({ topic }:Readonly<OptionCardProps>) {
    const navigate = useNavigate();

    function handleClick() {
        navigate(`/question/${topic.id}`)
    }

    return (
        <button className={"option-card"} onClick={handleClick}>
            <img className={topic.title.toLowerCase() + "-img topic-img"} src={topic.icon} alt={topic.title + " illustration"} />
            <span className={"option-text"}>{topic.title}</span>
        </button>
    );
}

export default TopicCard;
